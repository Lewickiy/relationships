package org.lewickiy.relationships.controller;

import org.lewickiy.relationships.model.House;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "api/v1/house")
public interface HouseController {
    @GetMapping
    List<House> getAllHouses();

    @GetMapping(value = "/{id}")
    Optional<House> findHouseById(
            @PathVariable(value = "id") Long id);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    void addNewHouse(@RequestBody House house);

    @DeleteMapping({"/{id}"})
    void deleteHouseById(@PathVariable(value = "id") Long id);
}
