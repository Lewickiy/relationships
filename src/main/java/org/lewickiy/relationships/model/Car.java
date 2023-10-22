package org.lewickiy.relationships.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "citizen_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Citizen citizen;
}
