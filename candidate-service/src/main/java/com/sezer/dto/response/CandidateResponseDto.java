package com.sezer.dto.response;

import com.sezer.repository.entity.Interaction;
import com.sezer.repository.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateResponseDto {
    private Long id;
    private String nameSurname;
    private List<Interaction> previousInteractions;
    private Status status;
    private String email;
    private String phone;
}
