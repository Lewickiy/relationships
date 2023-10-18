package org.lewickiy.relationships.configuration;

import org.lewickiy.relationships.model.Citizen;
import org.lewickiy.relationships.repository.CitizenRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.util.Calendar.DECEMBER;
import static java.util.Calendar.NOVEMBER;

@Configuration
public class CitizenConfig {

    //Временная история для заполнения таблицы горожан
    @Bean
    CommandLineRunner commandLineRunner(CitizenRepository repository) {
        return args -> {
            Citizen citizenOne = new Citizen();
            citizenOne.setName("Alisson");
            citizenOne.setBirthday(LocalDate.of(2000, DECEMBER, 22));
            Citizen citizenTwo = new Citizen();
            citizenTwo.setName("Dmitriy");
            citizenTwo.setBirthday(LocalDate.of(1998, NOVEMBER, 13));
            repository.saveAll(List.of(citizenOne, citizenTwo));
        };
    }
}
