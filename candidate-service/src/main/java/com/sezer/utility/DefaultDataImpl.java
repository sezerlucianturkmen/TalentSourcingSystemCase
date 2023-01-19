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
                .date("2022-03-12")
                .candidateResponded(true)
                .candidate(candidate1)
                .build();
        interactionService.save(interaction1);
        Interaction interaction2=Interaction.builder()
                .interactionType(InteractionType.PHONE)
                .content("Second meeting call")
                .date("2023-04-24")
                .candidateResponded(true)
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
                .date("2022-07-04")
                .candidateResponded(true)
                .candidate(candidate2)
                .build();
        interactionService.save(interaction3);
        Interaction interaction4=Interaction.builder()
                .interactionType(InteractionType.PHONE)
                .content("Second meeting call")
                .date("2023-01-23")
                .candidateResponded(true)
                .candidate(candidate2)
                .build();
        interactionService.save(interaction4);
        Interaction interaction5=Interaction.builder()
                .interactionType(InteractionType.MAIL)
                .content("Offer is sent to the candidate")
                .date("2022-12-28")
                .candidateResponded(true)
                .candidate(candidate2)
                .build();
        interactionService.save(interaction5);

        candidate2.setContactInformation(contactInformation2);
        candidate2.setPreviousInteractions(Arrays.asList(interaction3,interaction4,interaction5));
        candidateService.save(candidate2);

        //3
        Candidate candidate3=Candidate.builder()
                .nameSurname("Francesca Ferrari")
                .status(Status.SOURCED)
                .build();
        candidateService.save(candidate3);

        ContactInformation contactInformation3=ContactInformation.builder()
                .email("francesca@gmail.com")
                .phone("+90 505 005 6677")
                .candidate(candidate3)
                .build();
        contactInformationService.save(contactInformation3);

        Interaction interaction6=Interaction.builder()
                .interactionType(InteractionType.PHONE)
                .content("Initial meeting call")
                .date("2022-11-10")
                .candidateResponded(true)
                .candidate(candidate3)
                .build();
        interactionService.save(interaction6);
        Interaction interaction7=Interaction.builder()
                .interactionType(InteractionType.PHONE)
                .content("Second meeting call")
                .date("2022-10-31")
                .candidateResponded(true)
                .candidate(candidate3)
                .build();
        interactionService.save(interaction7);

        candidate3.setContactInformation(contactInformation3);
        candidate3.setPreviousInteractions(Arrays.asList(interaction6,interaction7));
        candidateService.save(candidate3);

        //4
        Candidate candidate4=Candidate.builder()
                .nameSurname("Mehmet Yorulmazer")
                .status(Status.SOURCED)
                .build();
        candidateService.save(candidate4);

        ContactInformation contactInformation4=ContactInformation.builder()
                .email("mehmet@gmail.com")
                .phone("+90 555 775 6677")
                .candidate(candidate4)
                .build();
        contactInformationService.save(contactInformation4);

        Interaction interaction8=Interaction.builder()
                .interactionType(InteractionType.PHONE)
                .content("Initial meeting call")
                .date("2023-01-03")
                .candidateResponded(true)
                .candidate(candidate4)
                .build();
        interactionService.save(interaction8);


        candidate4.setContactInformation(contactInformation4);
        candidate4.setPreviousInteractions(Arrays.asList(interaction8));
        candidateService.save(candidate4);

        //5
        Candidate candidate5=Candidate.builder()
                .nameSurname("Sezer Turkmen")
                .status(Status.SOURCED)
                .build();
        candidateService.save(candidate5);

        ContactInformation contactInformation5=ContactInformation.builder()
                .email("sezer@gmail.com")
                .phone("+90 505 005 6666")
                .candidate(candidate5)
                .build();
        contactInformationService.save(contactInformation5);

        Interaction interaction9=Interaction.builder()
                .interactionType(InteractionType.PHONE)
                .content("Initial meeting call")
                .date("2022-10-10")
                .candidateResponded(true)
                .candidate(candidate5)
                .build();
        interactionService.save(interaction9);

        Interaction interaction10=Interaction.builder()
                .interactionType(InteractionType.PHONE)
                .content("Second meeting call")
                .date("2022-09-07")
                .candidateResponded(false)
                .candidate(candidate5)
                .build();
        interactionService.save(interaction10);

        candidate5.setContactInformation(contactInformation5);
        candidate5.setPreviousInteractions(Arrays.asList(interaction9,interaction10));
        candidateService.save(candidate5);


    }


}
