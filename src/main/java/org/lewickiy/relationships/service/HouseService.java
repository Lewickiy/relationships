package org.lewickiy.relationships.service;

import org.lewickiy.relationships.model.House;

import java.util.List;
import java.util.Optional;

public interface HouseService {
    List<House> getAllHouses();
    Optional<House> findHouseById(Long id);
    void addNewHouse(House house);
    void deleteHouseById(Long id);
}
