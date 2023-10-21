package org.lewickiy.relationships.controller.impl;

import org.lewickiy.relationships.controller.PassportController;
import org.lewickiy.relationships.model.Passport;
import org.lewickiy.relationships.service.impl.PassportServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PassportControllerImpl implements PassportController {
    private final PassportServiceImpl passportService;

    public PassportControllerImpl(PassportServiceImpl passportService) {
        this.passportService = passportService;
    }

    @Override
    public List<Passport> getAllPassports() {
        return passportService.getAllPassports();
    }

    @Override
    public Optional<Passport> findPassportById(Long id) {
        return passportService.findPassportById(id);
    }

    @Override
    public void addNewPassport(Passport passport) {
        passportService.addNewPassport(passport);
    }

    @Override
    public void deletePassportById(Long id) {
        passportService.deletePassportById(id);
    }
}
