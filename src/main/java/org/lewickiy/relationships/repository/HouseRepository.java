package org.lewickiy.relationships.repository;

import org.lewickiy.relationships.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {
}
