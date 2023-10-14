package org.lewickiy.relationships.controller;

import org.lewickiy.relationships.model.Citizen;
import org.lewickiy.relationships.repository.CitizenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/citizen/new")
    public String saveCitizen(Citizen citizen) {
        /*
        Здесь еще вероятно следует добавить списки недвижимости и автомобилей
        для того чтобы при создании гражданина можно было их назначать
         */
        citizenRepository.save(citizen);
        return "redirect:/citizen";
    }

    @GetMapping("/citizen/edit/{id}")
    public String showEditCitizenForm(@PathVariable("id") Integer id, Model model) {
        Citizen citizen = citizenRepository.findById(id).get();
        model.addAttribute("citizen", citizen);
        return "citizen_form";
    }

    @GetMapping("/citizen/delete/{id}")
    public String deleteCitizen(@PathVariable("id") Integer id) {
        citizenRepository.deleteById(id);
        return "redirect:/citizen";
    }

}
