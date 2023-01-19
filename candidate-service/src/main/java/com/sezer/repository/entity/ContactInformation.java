package com.sezer.repository.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tblinformation")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ContactInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String phone;
    @OneToOne
    @JoinColumn(name = "candidateid")
    private Candidate candidate;
}
