package org.lewickiy.relationships.service.impl;

import org.lewickiy.relationships.model.House;
import org.lewickiy.relationships.repository.HouseRepository;
import org.lewickiy.relationships.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;

    @Autowired
    public HouseServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

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
