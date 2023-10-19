package org.lewickiy.relationships.controller;

import org.lewickiy.relationships.controller.impl.CitizenController;
import org.lewickiy.relationships.model.Citizen;
import org.lewickiy.relationships.service.impl.CitizenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/citizen")
public class CitizenControllerImpl implements CitizenController {

    private final CitizenServiceImpl citizenService;

    @Autowired
    public CitizenControllerImpl(CitizenServiceImpl citizenService) {
        this.citizenService = citizenService;
    }

    @Override
    public List<Citizen> getCitizens() {
        return citizenService.getAllCitizens();
    }

    @Override
    public void addNewCitizen(Citizen citizen) {
        citizenService.addNewCitizen(citizen);
    }
}
