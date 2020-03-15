package ru.iopent.parking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "parkings")
public class Parking extends BaseEntity {
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "current_fullness", nullable = false)
    private Integer currentFullness;

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getCurrentFullness() {
        return currentFullness;
    }

    public void setCurrentFullness(Integer currentFullness) {
        this.currentFullness = currentFullness;
    }
}
