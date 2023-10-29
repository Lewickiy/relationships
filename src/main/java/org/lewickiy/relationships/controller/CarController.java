package org.lewickiy.relationships.controller;

import org.lewickiy.relationships.model.Car;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "api/v1/car")
public interface CarController {
    @GetMapping
    List<Car> getAllCars();

    @GetMapping(value = "/{id}")
    Optional<Car> findCarById(
            @PathVariable(value = "id") Long id);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    void addNewCar(@RequestBody Car car);

    @DeleteMapping({"/{id}"})
    void deleteCarById(@PathVariable(value = "id") Long id);
}
