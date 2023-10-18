package org.lewickiy.relationships.service.impl;

import org.lewickiy.relationships.model.Citizen;
import org.lewickiy.relationships.repository.CitizenRepository;
import org.lewickiy.relationships.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenServiceImpl implements CitizenService {

    private final CitizenRepository citizenRepository;

    @Autowired
    public CitizenServiceImpl(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    @Override
    public List<Citizen> getAllCitizens() {
        return citizenRepository.findAll();
    }

    @Override
    public void addNewCitizen(Citizen citizen) {
        System.out.println(citizen);
    }
}
