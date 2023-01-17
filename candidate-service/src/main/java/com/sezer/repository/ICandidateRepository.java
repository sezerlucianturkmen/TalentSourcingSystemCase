package com.sezer.repository;

import com.sezer.repository.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICandidateRepository extends JpaRepository<Candidate,Long> {
}
