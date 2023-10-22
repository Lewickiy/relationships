package org.lewickiy.relationships.repository;

import org.lewickiy.relationships.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
