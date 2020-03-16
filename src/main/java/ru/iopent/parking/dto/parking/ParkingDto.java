package ru.iopent.parking.dto.parking;

public class ParkingDto {
    private final Integer id;
    private final String description;
    private final Integer capacity;

    public ParkingDto(Integer id, String description, Integer capacity) {
        this.id = id;
        this.description = description;
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCapacity() {
        return capacity;
    }

}