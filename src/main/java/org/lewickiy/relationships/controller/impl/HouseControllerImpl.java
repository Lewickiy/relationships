package org.lewickiy.relationships.controller.impl;

import lombok.AllArgsConstructor;
import org.lewickiy.relationships.controller.HouseController;
import org.lewickiy.relationships.model.House;
import org.lewickiy.relationships.service.HouseService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class HouseControllerImpl implements HouseController {
    private final HouseService houseService;

    @Override
    public List<House> getAllHouses() {
        return houseService.getAllHouses();
    }

    @Override
    public Optional<House> findHouseById(Long id) {
        return houseService.findHouseById(id);
    }

    @Override
    public void addNewHouse(House house) {
        houseService.addNewHouse(house);
    }

    @Override
    public void deleteHouseById(Long id) {
        houseService.deleteHouseById(id);
    }
}
