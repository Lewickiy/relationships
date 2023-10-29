package org.lewickiy.relationships.controller;

import org.lewickiy.relationships.model.House;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
