package com.sezer.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sezer.repository.enums.InteractionType;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tblinteraction")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public  class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonIgnore
    private Candidate candidate;
    private String content;
    private String date;
    private Boolean candidate_responded;
    @Enumerated(EnumType.STRING)
    private InteractionType interactionType;
}
