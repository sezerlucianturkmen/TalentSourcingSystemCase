package com.sezer.repository;

import com.sezer.repository.entity.Candidate;
import com.sezer.repository.entity.ContactInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IContactInformationRepository extends JpaRepository<ContactInformation,Long> {

    Optional<ContactInformation> findOptionalByCandidate(Candidate candidate);
}
