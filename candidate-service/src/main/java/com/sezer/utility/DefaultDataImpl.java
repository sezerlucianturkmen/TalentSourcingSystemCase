package com.sezer.utility;


import com.sezer.repository.entity.Candidate;
import com.sezer.repository.entity.ContactInformation;
import com.sezer.repository.entity.Interaction;
import com.sezer.repository.enums.InteractionType;
import com.sezer.repository.enums.Status;
import com.sezer.service.CandidateService;
import com.sezer.service.ContactInformationService;
import com.sezer.service.InteractionService;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@RequiredArgsConstructor
@Component
public class DefaultDataImpl {

    private  final CandidateService candidateService;
    private final InteractionService interactionService;

    private final ContactInformationService contactInformationService;

    @PostConstruct
    private  void create(){
        saveImplToDatabase();
    }

    private void saveImplToDatabase() {

        //1
        Candidate candidate1=Candidate.builder()
                .nameSurname("John Black")
                .status(Status.INTERVIEWING)
                .build();
        candidateService.save(candidate1);

        ContactInformation contactInformation1=ContactInformation.builder()
                .email("johnblack@gmail.com")
                .phone("+90 505 555 6788")
                .candidate(candidate1)
                .build();
        contactInformationService.save(contactInformation1);

        Interaction interaction1=Interaction.builder()
                .interactionType(InteractionType.PHONE)
                .content("Initial meeting call")
                .date("22-12-2022")
                .candidate_responded(true)
                .candidate(candidate1)
                .build();
        interactionService.save(interaction1);
        Interaction interaction2=Interaction.builder()
                .interactionType(InteractionType.PHONE)
                .content("Second meeting call")
                .date("02-01-2023")
                .candidate_responded(true)
                .candidate(candidate1)
                .build();
        interactionService.save(interaction2);

        candidate1.setContactInformation(contactInformation1);
        candidate1.setPreviousInteractions(Arrays.asList(interaction1,interaction2));
        candidateService.save(candidate1);

        //2
        Candidate candidate2=Candidate.builder()
                .nameSurname("Mert Yilmaz")
                .status(Status.OFFER_SENT)
                .build();
        candidateService.save(candidate2);

        ContactInformation contactInformation2=ContactInformation.builder()
                .email("mertyilmaz@gmail.com")
                .phone("+90 505 555 6677")
                .candidate(candidate2)
                .build();
        contactInformationService.save(contactInformation2);

        Interaction interaction3=Interaction.builder()
                .interactionType(InteractionType.PHONE)
                .content("Initial meeting call")
                .date("27-12-2022")
                .candidate_responded(true)
                .candidate(candidate2)
                .build();
        interactionService.save(interaction3);
        Interaction interaction4=Interaction.builder()
                .interactionType(InteractionType.PHONE)
                .content("Second meeting call")
                .date("06-01-2023")
                .candidate_responded(true)
                .candidate(candidate2)
                .build();
        interactionService.save(interaction4);
        Interaction interaction5=Interaction.builder()
                .interactionType(InteractionType.MAIL)
                .content("Offer is sent to the candidate")
                .date("12-01-2023")
                .candidate_responded(true)
                .candidate(candidate2)
                .build();
        interactionService.save(interaction5);

        candidate2.setContactInformation(contactInformation2);
        candidate2.setPreviousInteractions(Arrays.asList(interaction3,interaction4,interaction5));
        candidateService.save(candidate2);

    }


}
