package org.lewickiy.relationships.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "citizen")
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
    private Integer id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id", referencedColumnName = "passport_id")
    private Passport passport; //Not created yet
    /*
    TODO On the other side
    @OneToOne(mappedBy = "citizen")
    private Citizen citizen;

     */

    @ManyToMany
    @JoinTable(
            name = "citizen_house",
            joinColumns = @JoinColumn(name = "citizen_id"),
            inverseJoinColumns = @JoinColumn(name = "house_id")
    )
    private List<House> houses; //many-to-many

    /*
    @ManyToMany(mappedBy = "houses")
    Set<Citizen> citizenHouses;
     */

    @OneToMany(mappedBy = "citizen")
    private Set<Car> cars; //one to many

    /*
    TODO On the other side
    @ManyToOne
    @JoinColumn(name="citizen_id", nullable=false)
    private Citizen citizen;
     */

    @CreationTimestamp
    @Column(name = "created_date")
    private Date createDate;
    
    @UpdateTimestamp
    @Column(name = "updated_date")
    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
