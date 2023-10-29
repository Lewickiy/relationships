package org.lewickiy.relationships.controller.impl;

import lombok.AllArgsConstructor;
import org.lewickiy.relationships.controller.CarController;
import org.lewickiy.relationships.dto.CarDto;
import org.lewickiy.relationships.model.Car;
import org.lewickiy.relationships.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CarControllerImpl implements CarController {
    @Autowired
    private ModelMapper modelMapper;
    private final CarService carService;

    @Override
    public List<CarDto> getAllCars() {
        List<Car> cars = carService.getAllCars();
        return cars.stream().map(this::convertToDto).collect(Collectors.toList());
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

    private CarDto convertToDto(Car car) {
        CarDto carDto = modelMapper.map(car, CarDto.class);
        return carDto;
    }

    private Car convertToModel(CarDto carDto) {
        Car car = modelMapper.map(carDto, Car.class);
        return car;
    }
}
