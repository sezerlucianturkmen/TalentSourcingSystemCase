package com.sezer.service;

import com.sezer.repository.IContactInformationRepository;
import com.sezer.repository.entity.Candidate;
import com.sezer.repository.entity.ContactInformation;
import com.sezer.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ContactInformationService extends ServiceManager<ContactInformation,Long> {
    private final IContactInformationRepository repository;

    public ContactInformationService(IContactInformationRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public ContactInformation findByCandidate(Candidate candidate){
        return repository.findOptionalByCandidate(candidate).get();
    }
}
