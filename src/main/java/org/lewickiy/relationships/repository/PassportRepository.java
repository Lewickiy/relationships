package org.lewickiy.relationships.repository;

import org.lewickiy.relationships.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport, Long> {

}
