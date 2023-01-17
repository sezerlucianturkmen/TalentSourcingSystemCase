package com.sezer.service;

import com.sezer.dto.request.CreateInteractionRequestDto;
import com.sezer.dto.request.UpdateInteractionRequestDto;
import com.sezer.dto.response.CandidateResponseDto;
import com.sezer.dto.response.InteractionResponseDto;
import com.sezer.exception.ErrorType;
import com.sezer.exception.ManagerException;
import com.sezer.mapper.IInteractionMapper;
import com.sezer.repository.IInteractionRepository;
import com.sezer.repository.entity.Candidate;
import com.sezer.repository.entity.Interaction;
import com.sezer.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InteractionService extends ServiceManager<Interaction,Long> {
    private final IInteractionRepository repository;
    private final CandidateService candidateService;

    public InteractionService(IInteractionRepository repository,CandidateService candidateService) {
        super(repository);
        this.repository = repository;
        this.candidateService=candidateService;
    }

    public CandidateResponseDto createInteraction(CreateInteractionRequestDto dto) {
        Optional<Candidate> candidate = candidateService.findById(dto.getCandidateid());
        if(candidate.isPresent()){
            Interaction interaction=IInteractionMapper.INSTANCE.toInteraction(dto);
            interaction.setCandidate(candidate.get());
            save(interaction);
            Candidate candidateReturn=assignInteraction(interaction,candidate.get().getId()).get();
            return CandidateResponseDto.builder()
                    .id(candidateReturn.getId())
                    .nameSurname(candidateReturn.getNameSurname())
                    .status(candidateReturn.getStatus())
                    .previousInteractions(candidateReturn.getPreviousInteractions())
                    .phone(candidateReturn.getContactInformation().getPhone())
                    .email(candidateReturn.getContactInformation().getEmail())
                    .build();
        }else{
            throw new ManagerException(ErrorType.CANDIDATE_NOT_FOUND);
        }
    }

    public Optional<Candidate> assignInteraction(Interaction interaction, Long id){
        Optional<Candidate> candidate = candidateService.findById(id);
        candidate.get().getPreviousInteractions().add(interaction);
        return  Optional.of(candidateService.save(candidate.get()));

    }

    public CandidateResponseDto updateInteraction(UpdateInteractionRequestDto dto) {
        Optional<Interaction> interaction = findById(dto.getId());
        if(interaction.isPresent()){
            interaction.get().setContent(dto.getContent());
            interaction.get().setDate(dto.getDate());
            interaction.get().setInteractionType(dto.getInteractionType());
            interaction.get().setCandidate_responded(dto.getCandidate_responded());
            save(interaction.get());
            Candidate candidateReturn =candidateService.findById(dto.getCandidateid()).get();
            return CandidateResponseDto.builder()
                    .id(candidateReturn.getId())
                    .nameSurname(candidateReturn.getNameSurname())
                    .status(candidateReturn.getStatus())
                    .previousInteractions(candidateReturn.getPreviousInteractions())
                    .phone(candidateReturn.getContactInformation().getPhone())
                    .email(candidateReturn.getContactInformation().getEmail())
                    .build();

        }else{
            throw new ManagerException(ErrorType.INTERACTION_NOT_FOUND);
        }
    }

    public List<InteractionResponseDto> findAllInteraction(Long candidateid) {
        Optional<List<Interaction>> interactions=repository.findAllOptionalByCandidate(candidateService.findById(candidateid).get());
        if(interactions.isPresent()){
            return interactions.get().stream().map(x-> {
                InteractionResponseDto dto =IInteractionMapper.INSTANCE.toInteractionResponseDto(x);
                dto.setCandidateid(x.getCandidate().getId());
                return dto;
            }).collect(Collectors.toList());
        }else{
            throw new ManagerException(ErrorType.INTERACTION_NOT_FOUND);
        }
    }

    public Boolean deleteInteraction(Long id) {
        Optional<Interaction> interaction=findById(id);
        if(interaction.isPresent()){
            delete(interaction.get());
            return true;
        }else{
            throw new ManagerException(ErrorType.INTERACTION_NOT_FOUND);
        }
    }
}
