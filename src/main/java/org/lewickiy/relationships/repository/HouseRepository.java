package org.lewickiy.relationships.repository;

import org.lewickiy.relationships.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface HouseRepository extends JpaRepository<House, Long> {
}
