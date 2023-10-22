package org.lewickiy.relationships.configuration;

import org.lewickiy.relationships.model.Car;
import org.lewickiy.relationships.model.Citizen;
import org.lewickiy.relationships.model.House;
import org.lewickiy.relationships.model.Passport;
import org.lewickiy.relationships.repository.CarRepository;
import org.lewickiy.relationships.repository.CitizenRepository;
import org.lewickiy.relationships.repository.HouseRepository;
import org.lewickiy.relationships.repository.PassportRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Calendar.*;

@Configuration
public class RelationShipsConfig {
    @Bean
    CommandLineRunner commandLineRunner(CitizenRepository repository, HouseRepository houseRepository, CarRepository carRepository) {
        return args -> {
            Citizen citizenOne = new Citizen();
            citizenOne.setFirstname("Alisson");
            citizenOne.setLastName("Wonkens");
            citizenOne.setBirthday(LocalDate.of(2000, DECEMBER, 22));
            Passport passportOne = new Passport();
            passportOne.setDateOfIssue(LocalDate.of(2010, AUGUST, 11));
            passportOne.setValidity(20);
            House houseOne = new House();
            houseOne.setName("Main home of citizen one");
            houseOne.setAddress("минский пер. д.6");
            House houseTwo = new House();
            houseTwo.setName("Other home");
            houseTwo.setAddress("Большевиков 26");
            houseRepository.saveAll(List.of(houseOne, houseTwo));
            citizenOne.setPassport(passportOne);
            citizenOne.setHouses(List.of(houseOne, houseTwo));

            Car carOne = new Car();
            carOne.setModel("Volvo");
            carOne.setCitizen(citizenOne);
            Car carTwo = new Car();
            carTwo.setModel("Ford");
            carTwo.setCitizen(citizenOne);

            repository.save(citizenOne);
            carRepository.saveAll(List.of(carOne, carTwo));




            carOne.setCitizen(citizenOne);
            carTwo.setCitizen(citizenOne);

            Citizen citizenTwo = new Citizen();
            Passport passportTwo = new Passport();
            passportTwo.setDateOfIssue(LocalDate.of(1985, JUNE, 11));
            passportTwo.setValidity(30);
            citizenTwo.setFirstname("Dmitriy");
            citizenTwo.setLastName("Aksionov");
            citizenTwo.setBirthday(LocalDate.of(1998, NOVEMBER, 13));
            citizenTwo.setPassport(passportTwo);
            House houseThree = new House();
            houseThree.setName("Main home of citizen two");
            houseThree.setAddress("Невский пр. 102");
            citizenTwo.setHouses(List.of(houseThree, houseTwo));
            houseRepository.save(houseThree);
            repository.save(citizenTwo);
        };
    }
}
