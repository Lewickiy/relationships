package org.lewickiy.relationships.service.impl;

import lombok.AllArgsConstructor;
import org.lewickiy.relationships.model.House;
import org.lewickiy.relationships.repository.HouseRepository;
import org.lewickiy.relationships.service.HouseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;

    @Override
    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }

    @Override
    public Optional<House> findHouseById(Long id) {
        return houseRepository.findById(id);
    }

    @Override
    public void addNewHouse(House house) {
        houseRepository.save(house);
    }

    @Override
    public void deleteHouseById(Long id) {
        houseRepository.deleteById(id);
    }
}
