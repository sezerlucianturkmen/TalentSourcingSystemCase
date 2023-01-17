package com.sezer.dto.request;

import com.sezer.repository.enums.InteractionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateInteractionRequestDto {
    private Long candidateid;
    private String content;
    private String date;
    private Boolean candidate_responded;
    private InteractionType interactionType;
}
