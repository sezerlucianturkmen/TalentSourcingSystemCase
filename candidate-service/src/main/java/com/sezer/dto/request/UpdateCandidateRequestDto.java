package com.sezer.dto.request;

import com.sezer.repository.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateCandidateRequestDto {
    private Long id;
    private String nameSurname;
    private String email;
    private String phone;
    private String status;
}
