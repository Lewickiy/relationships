package org.lewickiy.relationships.service.impl;

import org.lewickiy.relationships.model.Citizen;
import org.lewickiy.relationships.repository.CitizenRepository;
import org.lewickiy.relationships.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Citizen> findCitizenById(Long id) {
        return citizenRepository.findById(id);
    }

    @Override
    public void addNewCitizen(Citizen citizen) {
        citizenRepository.save(citizen);
    }

    @Override
    public void deleteCitizenById(Long id) {
        citizenRepository.deleteById(id);
    }
}
