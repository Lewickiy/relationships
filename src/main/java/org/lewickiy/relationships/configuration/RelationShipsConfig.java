package org.lewickiy.relationships.configuration;

import org.lewickiy.relationships.model.Citizen;
import org.lewickiy.relationships.model.House;
import org.lewickiy.relationships.model.Passport;
import org.lewickiy.relationships.repository.CitizenRepository;
import org.lewickiy.relationships.repository.HouseRepository;
import org.lewickiy.relationships.repository.PassportRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.util.Calendar.*;

@Configuration
public class RelationShipsConfig {
    //Временная история для заполнения таблицы горожан
    @Bean
    CommandLineRunner commandLineRunner(CitizenRepository repository, HouseRepository houseRepository) {
        return args -> {
            Passport passportOne = new Passport();
            passportOne.setDateOfIssue(LocalDate.of(2010, AUGUST, 11));
            passportOne.setValidity(20);

            House houseOne = new House();
            houseOne.setName("Main home");
            houseOne.setAddress("минский пер. д.6");
            House houseTwo = new House();
            houseTwo.setName("Other home");
            houseTwo.setAddress("большевиков 26");
            houseRepository.saveAll(List.of(houseOne, houseTwo));

            Citizen citizenOne = new Citizen();
            citizenOne.setFirstname("Alisson");
            citizenOne.setLastName("Wonkens");
            citizenOne.setBirthday(LocalDate.of(2000, DECEMBER, 22));
            citizenOne.setPassport(passportOne);
            citizenOne.setHouses(List.of(houseOne, houseTwo));
            repository.save(citizenOne);

            Passport passportTwo = new Passport();
            passportTwo.setDateOfIssue(LocalDate.of(1985, JUNE, 11));
            passportTwo.setValidity(30);
            Citizen citizenTwo = new Citizen();
            citizenTwo.setFirstname("Dmitriy");
            citizenTwo.setLastName("Aksionov");
            citizenTwo.setBirthday(LocalDate.of(1998, NOVEMBER, 13));
            citizenTwo.setPassport(passportTwo);
            repository.save(citizenTwo);
        };
    }
}
