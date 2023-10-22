package org.lewickiy.relationships.controller.impl;

import org.lewickiy.relationships.controller.CarController;
import org.lewickiy.relationships.model.Car;
import org.lewickiy.relationships.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CarControllerImpl implements CarController {
    private final CarService carService;

    @Autowired
    public CarControllerImpl(CarService carService) {
        this.carService = carService;
    }

    @Override
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @Override
    public Optional<Car> findCarById(Long id) {
        return carService.findCarById(id);
    }

    @Override
    public void addNewCar(Car car) {
        carService.addNewCar(car);
    }

    @Override
    public void deleteCarById(Long id) {
        carService.deleteCarById(id);
    }
}
