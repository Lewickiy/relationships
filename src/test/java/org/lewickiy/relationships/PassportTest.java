package org.lewickiy.relationships;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.lewickiy.relationships.model.Passport;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassportTest {

    @Test
    @DisplayName("Checking the formation of the passport expiration date")
    public void passportExpirationDateCheck() {
        Passport passport = new Passport();
        LocalDate ld = LocalDate.of(2021, 1, 1);
        passport.setDateOfIssue(ld);
        passport.setValidity(3);

        assertEquals(passport.getExpirationDate(), LocalDate.of(2024, 1, 1));
    }

}
