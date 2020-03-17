package ru.iopent.parking.dto.sensor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SensorDto {
    private final Integer number;
    private final Boolean isBusy;
}
