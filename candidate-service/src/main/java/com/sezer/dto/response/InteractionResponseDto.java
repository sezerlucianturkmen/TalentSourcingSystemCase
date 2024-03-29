package com.sezer.dto.response;

import com.sezer.repository.enums.InteractionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InteractionResponseDto {
    private Long id;
    private Long candidateid;
    private String content;
    private String date;
    private Boolean candidateResponded;
    private InteractionType interactionType;
    private String nameSurname;
    private String email;
    private String phone;

}
