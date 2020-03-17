package ru.iopent.parking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "sensors")
public class Sensor extends BaseEntity {
    @Column(name = "parking_id")
    private Integer parkingId;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "is_busy", nullable = false)
    private Boolean busy;
}