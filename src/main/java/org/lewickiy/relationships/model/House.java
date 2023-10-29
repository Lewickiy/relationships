package org.lewickiy.relationships.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "houses")
@Entity
public class House {
    @Id
    @Column(name = "house_id")
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "house_id_generator"
    )
    @SequenceGenerator(
            name = "house_id_generator",
            sequenceName = "house_sequence_id",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR (55) comment 'House name'")
    private String name;

    @Column(name = "addr", columnDefinition = "TEXT comment 'Address'", nullable = false)
    private String address;

    @ManyToMany(mappedBy = "houses")
    @JsonIgnore
    private Set<Citizen> citizens;
}
