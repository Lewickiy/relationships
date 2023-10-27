package org.lewickiy.relationships.controller.impl;

import lombok.AllArgsConstructor;
import org.lewickiy.relationships.controller.CitizenController;
import org.lewickiy.relationships.model.Citizen;
import org.lewickiy.relationships.model.Passport;
import org.lewickiy.relationships.service.impl.CitizenServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CitizenControllerImpl implements CitizenController {
    private final CitizenServiceImpl citizenService;

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
        Passport passport = new Passport();
        citizen.setPassport(passport);
        citizenService.addNewCitizen(citizen);
    }

    @Override
    public void deleteCitizenById(Long id) {
        citizenService.deleteCitizenById(id);
    }
}
