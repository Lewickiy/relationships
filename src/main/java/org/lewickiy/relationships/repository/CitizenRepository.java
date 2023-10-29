package org.lewickiy.relationships.repository;

import org.lewickiy.relationships.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {
}
