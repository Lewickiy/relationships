package org.lewickiy.relationships.dto;

import lombok.Data;
import org.lewickiy.relationships.model.Citizen;

@Data
public class CarDto {
    private Long id;
    private String model;
    private Citizen citizen;

    public CarDto(Long id, String model, Citizen citizen) {
        this.id = id;
        this.model = model;
        this.citizen = citizen;
    }

    public CarDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }
}
