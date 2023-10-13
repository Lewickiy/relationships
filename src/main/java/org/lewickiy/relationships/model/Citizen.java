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

    //TODO
    @ManyToMany
    private List<House> houses; //many-to-many

    //TODO
    @OneToMany
    private List<Car> cars; //one to many

    /*
    On the other side
    @OneToOne(mappedBy = "citizen")
    private Citizen citizen;
    */

    @CreationTimestamp
    @Column(name = "created_date")
    private Date currentDate;
    
    @UpdateTimestamp
    @Column(name = "updated_date")
    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
