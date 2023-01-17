package com.sezer.repository;

import com.sezer.repository.entity.Candidate;
import com.sezer.repository.entity.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IInteractionRepository extends JpaRepository<Interaction,Long> {

    Optional<List<Interaction>> findAllOptionalByCandidate(Candidate candidate);
}
