package org.lewickiy.relationships.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
@Entity
public class Car{
    @Id
    @Column(name = "car_id")
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "car_id_generator"
    )
    @SequenceGenerator(
            name = "car_id_generator",
            sequenceName = "car_sequence_id",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "model")
    private String model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "citizen_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Citizen citizen;
}
