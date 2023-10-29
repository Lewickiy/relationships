package org.lewickiy.relationships.service.impl;

import lombok.AllArgsConstructor;
import org.lewickiy.relationships.model.Passport;
import org.lewickiy.relationships.repository.PassportRepository;
import org.lewickiy.relationships.service.PassportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PassportServiceImpl implements PassportService {
    private final PassportRepository passportRepository;

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
