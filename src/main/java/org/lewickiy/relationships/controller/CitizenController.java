package org.lewickiy.relationships.controller;

import org.lewickiy.relationships.model.Citizen;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "api/v1/citizen")
public interface CitizenController {
    @GetMapping
    List<Citizen> getAllCitizens();

    @GetMapping(value = "/{id}")
    Optional<Citizen> findCitizenById(
            @PathVariable(value = "id") Long id);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    void addNewCitizen(@RequestBody Citizen citizen);

    @DeleteMapping({"/{id}"})
    void deleteCitizenById(@PathVariable(value = "id") Long id);
}
