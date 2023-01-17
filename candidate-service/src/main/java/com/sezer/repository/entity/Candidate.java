package com.sezer.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sezer.repository.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Table(name = "tblcandidate")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameSurname;
    @OneToMany(mappedBy = "candidate")
    @JsonIgnore
    private List<Interaction> previousInteractions;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Status status=Status.SOURCED;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contactinformationid")
    private ContactInformation contactInformation;
}
