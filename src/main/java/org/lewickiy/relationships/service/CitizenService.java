package org.lewickiy.relationships.service;

import org.lewickiy.relationships.model.Citizen;

import java.util.List;

public interface CitizenService {
    List<Citizen> getAllCitizens();

    void addNewCitizen(Citizen citizen);
}
