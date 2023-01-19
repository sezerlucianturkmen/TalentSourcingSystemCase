package com.sezer.dto.request;

import com.sezer.repository.enums.InteractionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateInteractionRequestDto {
    private Long id;
    private Long candidateid;
    private String content;
}
