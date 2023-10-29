package org.lewickiy.relationships.service.impl;

import lombok.AllArgsConstructor;
import org.lewickiy.relationships.model.Car;
import org.lewickiy.relationships.repository.CarRepository;
import org.lewickiy.relationships.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findCarById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public void addNewCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }
}
