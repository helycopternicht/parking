package ru.iopent.parking.dto.parking;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class CreateParkingRequest {
    @Size(min = 1, max = 255)
    private final String description;

    @Min(1)
    private final Integer capacity;

    public CreateParkingRequest(@Size(min = 1, max = 255) String description, @Min(1) Integer capacity) {
        this.description = description;
        this.capacity = capacity;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getCapacity() {
        return this.capacity;
    }
}
