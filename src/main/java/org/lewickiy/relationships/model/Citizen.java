package org.lewickiy.relationships.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "citizens")
@Entity
public class Citizen {
    @Id
    @Column(name = "citizen_id")
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "citizen_id_generator"
    )
    @SequenceGenerator(
            name = "citizen_id_generator",
            sequenceName = "citizen_sequence_id",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "firstname", nullable = false, columnDefinition = "VARCHAR (55)")
    private String firstname;

    @Column(name = "last_name", columnDefinition = "VARCHAR (55)")
    private String lastName;

    @Column(name = "birthday", columnDefinition = "DATE")
    private LocalDate birthday;

    @Transient
    @Getter(AccessLevel.NONE)
    private Integer age;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id", referencedColumnName = "passport_id", nullable = false)
    private Passport passport;

    @ManyToMany
    @JoinTable(
            name = "citizen_house",
            joinColumns = @JoinColumn(name = "citizen_id"),
            inverseJoinColumns = @JoinColumn(name = "house_id")
    )
    private List<House> houses;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "citizen_id", referencedColumnName = "citizen_id")
    private Set<Car> cars;

    @CreationTimestamp
    @Column(name = "created_date")
    private Date createDate;
    
    @UpdateTimestamp
    @Column(name = "updated_date")
    private Date updateDate;

    public Integer getAge() {
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }
}
