package org.lewickiy.relationships.controller.impl;

import org.lewickiy.relationships.model.Citizen;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CitizenController {
    @GetMapping
    public List<Citizen> getCitizens();

    @PostMapping
    public void addNewCitizen(@RequestBody Citizen citizen);
}
