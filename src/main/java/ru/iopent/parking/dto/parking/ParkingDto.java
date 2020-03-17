package ru.iopent.parking.dto.parking;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ParkingDto {
    private final Integer id;
    private final String description;
    private final Integer capacity;
}