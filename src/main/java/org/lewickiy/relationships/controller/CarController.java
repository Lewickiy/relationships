package org.lewickiy.relationships.controller;

import org.lewickiy.relationships.model.Car;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
