package org.lewickiy.relationships.service;

import org.lewickiy.relationships.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> getAllCars();
    Optional<Car> findCarById(Long id);
    void addNewCar(Car car);
    void deleteCarById(Long id);
}
