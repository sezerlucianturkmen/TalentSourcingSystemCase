package com.sezer.service;

import com.sezer.dto.request.CreateCandidateRequestDto;
import com.sezer.dto.request.UpdateCandidateRequestDto;
import com.sezer.dto.response.CandidateResponseDto;
import com.sezer.exception.ErrorType;
import com.sezer.exception.ManagerException;
import com.sezer.mapper.ICandidateMapper;
import com.sezer.repository.ICandidateRepository;
import com.sezer.repository.entity.Candidate;
import com.sezer.repository.entity.ContactInformation;
import com.sezer.repository.enums.Status;
import com.sezer.utility.ServiceManager;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidateService extends ServiceManager<Candidate,Long> {
    private final ICandidateRepository repository;
    private final ContactInformationService contactInformationService;


    public CandidateService(ICandidateRepository repository,ContactInformationService contactInformationService) {
        super(repository);
        this.repository = repository;
        this.contactInformationService=contactInformationService;

    }
    @Transactional
    public CandidateResponseDto createCandidate(CreateCandidateRequestDto dto) {

        try{

            Candidate candidate=createInitialCandidate(dto).get();
            candidate.setContactInformation(insertContactInformation(dto,candidate.getId()).get());
            save(candidate);

            return CandidateResponseDto.builder()
                    .id(candidate.getId())
                    .nameSurname(candidate.getNameSurname())
                    .status(candidate.getStatus())
                    .previousInteractions(candidate.getPreviousInteractions())
                    .phone(candidate.getContactInformation().getPhone())
                    .email(candidate.getContactInformation().getEmail())
                    .build();

        }catch (Exception e){
            throw new ManagerException(ErrorType.CANDIDATE_NOT_CREATED);
        }
    }
    @Transactional
    public Optional<Candidate> createInitialCandidate(CreateCandidateRequestDto dto){
        Candidate candidate= ICandidateMapper.INSTANCE.toCandidate(dto);
        return Optional.of(save(candidate));
    }
    @Transactional
    public Optional<ContactInformation> insertContactInformation(CreateCandidateRequestDto dto,Long id){
        ContactInformation contactInformation=ContactInformation.builder()
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .candidate(findById(id).get())
                .build();
        return Optional.of(contactInformationService.save(contactInformation));
    }

    @Transactional
    public CandidateResponseDto updateCandidate(UpdateCandidateRequestDto dto) {
      Optional<Candidate> candidate=findById(dto.getId());
      if(candidate.isPresent()){
          updateContactInformation(dto,candidate.get().getId());
          if(dto.getNameSurname().length()!=0 && dto.getStatus().length()!=0 ){
              candidate.get().setNameSurname(dto.getNameSurname());
              candidate.get().setStatus(Status.valueOf(dto.getStatus()));
          }else if(dto.getNameSurname().length()!=0){
              candidate.get().setNameSurname(dto.getNameSurname());
          }else if(dto.getStatus().length()!=0){
              candidate.get().setStatus(Status.valueOf(dto.getStatus()));
          }else{
              System.out.println("there is not any update.");
          }
          update(candidate.get());


          return CandidateResponseDto.builder()
                  .id(candidate.get().getId())
                  .nameSurname(candidate.get().getNameSurname())
                  .status(candidate.get().getStatus())
                  .previousInteractions(candidate.get().getPreviousInteractions())
                  .phone(candidate.get().getContactInformation().getPhone())
                  .email(candidate.get().getContactInformation().getEmail())
                  .build();

      }else{
          throw new ManagerException(ErrorType.CANDIDATE_NOT_FOUND);
      }
    }

    @Transactional
    public ContactInformation updateContactInformation(UpdateCandidateRequestDto dto,Long id){
        ContactInformation contactInformation=contactInformationService.findByCandidate(findById(id).get());

        if(dto.getPhone().length()!=0 && dto.getEmail().length()!=0 ){
            contactInformation.setPhone(dto.getPhone());
            contactInformation.setEmail(dto.getEmail());
        }else if(dto.getEmail().length()!=0){
            contactInformation.setEmail(dto.getEmail());
        }else if(dto.getPhone().length()!=0){
            contactInformation.setPhone(dto.getPhone());
        }else{
            System.out.println("there is not any update.");
        }
        contactInformationService.update(contactInformation);
        return contactInformation;
    }

    public List<CandidateResponseDto> findAllCandidates() {
        List<Candidate> candidateList=findAll();
        return candidateList.stream().map(x-> {
            CandidateResponseDto dto= ICandidateMapper.INSTANCE.toCandidateResponseDto(x);
            dto.setEmail(contactInformationService.findByCandidate(x).getEmail());
            dto.setPhone(contactInformationService.findByCandidate(x).getPhone());
            return dto;
        }).collect(Collectors.toList());
    }
    public List<CandidateResponseDto> findAllCandidatesSourced() {
        List<Candidate> candidateList=repository.findAllOptionalByStatus(Status.SOURCED);
        return candidateList.stream().map(x-> {
            CandidateResponseDto dto= ICandidateMapper.INSTANCE.toCandidateResponseDto(x);
            dto.setEmail(contactInformationService.findByCandidate(x).getEmail());
            dto.setPhone(contactInformationService.findByCandidate(x).getPhone());
            return dto;
        }).collect(Collectors.toList());
    }

    public Boolean deleteCandidate(Long id) {
        Optional<Candidate> candidate=repository.findById(id);
        if(candidate.isPresent()){
            deleteById(candidate.get().getId());
            return true;
        }else{
            throw new ManagerException(ErrorType.CANDIDATE_NOT_FOUND);
        }
    }


    public CandidateResponseDto findCandidate(Long id) {
        Optional<Candidate> candidate=repository.findById(id);
        if(candidate.isPresent()){
            CandidateResponseDto dto= ICandidateMapper.INSTANCE.toCandidateResponseDto(candidate.get());
            dto.setEmail(contactInformationService.findByCandidate(candidate.get()).getEmail());
            dto.setPhone(contactInformationService.findByCandidate(candidate.get()).getPhone());
            return dto;
        }else{
            throw new ManagerException(ErrorType.CANDIDATE_NOT_FOUND);

        }



        }
}
