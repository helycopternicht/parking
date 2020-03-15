package ru.iopent.parking.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class CreateParkingRequest {
    @Size(min = 1, max = 255)
    private String description;

    @Min(1)
    private Integer capacity;

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
}
