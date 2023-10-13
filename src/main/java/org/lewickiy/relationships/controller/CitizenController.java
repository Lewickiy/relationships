package org.lewickiy.relationships.controller;

import org.lewickiy.relationships.model.Citizen;
import org.lewickiy.relationships.repository.CitizenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CitizenController {
    private final CitizenRepository citizenRepository;

    public CitizenController(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    @GetMapping("/citizen")
    public String getCitizen(Model model) {
        List<Citizen> citizens = citizenRepository.findAll();
        model.addAttribute("citizens", citizens);
        return "citizen.html";
    }
}
