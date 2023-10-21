package org.lewickiy.relationships.controller;

import org.lewickiy.relationships.model.Passport;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "api/v1/passport")
public interface PassportController {
    @GetMapping
    List<Passport> getAllPassports();

    Optional<Passport> findPassportById(
            @PathVariable(value = "id") Long id);

    void addNewPassport(@RequestBody Passport passport);

    void deletePassportById(@PathVariable(value = "id") Long id);
}
