package org.lewickiy.relationships.service.impl;

import org.lewickiy.relationships.model.Passport;
import org.lewickiy.relationships.repository.PassportRepository;
import org.lewickiy.relationships.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassportServiceImpl implements PassportService {
    private final PassportRepository passportRepository;

    @Autowired
    public PassportServiceImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    public List<Passport> getAllPassports() {
        return passportRepository.findAll();
    }


    @Override
    public Optional<Passport> findPassportById(Long id) {
        return passportRepository.findById(id);
    }

    @Override
    public void addNewPassport(Passport passport) {
        passportRepository.save(passport);
    }

    @Override
    public void deletePassportById(Long id) {
        passportRepository.deleteById(id);
    }
}
