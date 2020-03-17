package ru.iopent.parking.dto.parking;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@RequiredArgsConstructor
public class CreateParkingRequest {
    @Size(min = 1, max = 255)
    private final String description;

    @Min(1)
    private final Integer capacity;
}
