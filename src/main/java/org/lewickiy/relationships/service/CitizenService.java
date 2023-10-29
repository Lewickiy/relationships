package org.lewickiy.relationships.service;

import org.lewickiy.relationships.model.Citizen;

import java.util.List;
import java.util.Optional;

public interface CitizenService {
    List<Citizen> getAllCitizens();
    Optional<Citizen> findCitizenById(Long id);
    void addNewCitizen(Citizen citizen);
    void deleteCitizenById(Long id);
}
