package org.lewickiy.relationships.controller.impl;

import org.lewickiy.relationships.controller.CitizenController;
import org.lewickiy.relationships.model.Citizen;
import org.lewickiy.relationships.model.Passport;
import org.lewickiy.relationships.service.impl.CitizenServiceImpl;
import org.lewickiy.relationships.service.impl.PassportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CitizenControllerImpl implements CitizenController {

    private final CitizenServiceImpl citizenService;
    private final PassportServiceImpl passportService;

    @Autowired
    public CitizenControllerImpl(CitizenServiceImpl citizenService, PassportServiceImpl passportService) {
        this.citizenService = citizenService;
        this.passportService = passportService;
    }

    @Override
    public List<Citizen> getAllCitizens() {
        return citizenService.getAllCitizens();
    }

    @Override
    public Optional<Citizen> findCitizenById(Long id) {
        return citizenService.findCitizenById(id);
    }


    @Override
    public void addNewCitizen(Citizen citizen) {
        citizenService.addNewCitizen(citizen);
    }

    @Override
    public void linkPassportByIdToCitizen(Long citizenId, Long passportId) {
        Citizen citizen;
        Passport passport;
        Optional<Citizen> optCitizen = citizenService.findCitizenById(citizenId);
        Optional<Passport> optPassport = passportService.findPassportById(passportId);
        if (optCitizen.isPresent() && optPassport.isPresent()) {
            citizen = optCitizen.get();
            passport = optPassport.get();
            citizen.setPassport(passport);
            citizenService.addNewCitizen(citizen);
        }
    }

    @Override
    public void deleteCitizenById(Long id) {
        citizenService.deleteCitizenById(id);
    }
}
