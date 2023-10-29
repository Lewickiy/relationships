package org.lewickiy.relationships.service;

import org.lewickiy.relationships.model.Passport;

import java.util.List;
import java.util.Optional;

public interface PassportService {
    List<Passport> getAllPassports();
    Optional<Passport> findPassportById(Long id);
    void addNewPassport(Passport passport);
    void deletePassportById(Long id);
}
