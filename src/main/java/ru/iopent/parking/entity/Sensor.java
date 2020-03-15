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
    private Boolean isBusy;

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
        return isBusy;
    }

    public void setBusy(Boolean busy) {
        isBusy = busy;
    }

    public Integer getId() {
        return id;
    }
}
