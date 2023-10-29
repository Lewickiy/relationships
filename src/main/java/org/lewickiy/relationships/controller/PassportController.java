package org.lewickiy.relationships.controller;

import org.lewickiy.relationships.model.Passport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "api/v1/passport")
public interface PassportController {
    @GetMapping
    List<Passport> getAllPassports();
    Optional<Passport> findPassportById(@PathVariable(value = "id") Long id);
}
