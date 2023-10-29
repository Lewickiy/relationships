package org.lewickiy.relationships.model;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

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

    //TODO Валидация серии с помощью инструментов Spring. Авто-генерация?
    @Column(name = "series")
    private String series;

    //TODO Валидация номера с помощью инструментов Spring. Авто-генерация?
    @Column(name = "number")
    private Integer number;
}
