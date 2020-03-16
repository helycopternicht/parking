package ru.iopent.parking.entity;

import javax.persistence.*;

@Entity
@Table(name = "sensors")
public class Sensor extends BaseEntity {
    @Column(name = "parking_id")
    private Integer parkingId;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "is_busy", nullable = false)
    private Boolean busy;

    public Integer getParkingId() {
        return parkingId;
    }

    public void setParkingId(Integer parkingId) {
        this.parkingId = parkingId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getBusy() {
        return busy;
    }

    public void setBusy(Boolean busy) {
        this.busy = busy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}