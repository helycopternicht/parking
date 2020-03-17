package ru.iopent.parking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "parkings")
public class Parking extends BaseEntity {
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;
}