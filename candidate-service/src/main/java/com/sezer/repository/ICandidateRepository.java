package com.sezer.repository;

import com.sezer.repository.entity.Candidate;
import com.sezer.repository.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICandidateRepository extends JpaRepository<Candidate,Long> {
    List<Candidate> findAllOptionalByStatus(Status status);
}
