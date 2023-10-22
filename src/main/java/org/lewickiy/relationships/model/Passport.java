package org.lewickiy.relationships.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "passport")
@Entity
public class Passport {
    @Id
    @Column(
            name = "passport_id",
            nullable = false,
            updatable = false
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "passport_id_generator"
    )
    @SequenceGenerator(
            name = "passport_id_generator",
            sequenceName = "passport_sequence_id",
            allocationSize = 1
    )
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "date_of_issue", updatable = false, nullable = false)
    private LocalDate dateOfIssue;

    @Column(name = "validity")
    private Integer validity;

    @Transient
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private LocalDate expirationDate;

    public LocalDate getExpirationDate() {
        return this.dateOfIssue.plusYears(validity);
    }
}
