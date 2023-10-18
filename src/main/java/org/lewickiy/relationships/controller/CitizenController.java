package org.lewickiy.relationships.controller;

import org.lewickiy.relationships.model.Citizen;
import org.lewickiy.relationships.service.impl.CitizenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/citizen")
public class CitizenController {

    private final CitizenServiceImpl citizenService;

    @Autowired
    public CitizenController(CitizenServiceImpl citizenService) {
        this.citizenService = citizenService;
    }

    @GetMapping
    public List<Citizen> getCitizens() {
        return citizenService.getAllCitizens();
    }

    @PostMapping
    public void addNewCitizen(@RequestBody Citizen citizen) {
        citizenService.addNewCitizen(citizen);
    }
}
