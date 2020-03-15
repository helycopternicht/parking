package ru.iopent.parking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SensorNotFoundException extends EntityNotFoundException {
    public SensorNotFoundException(Integer parkingId, Integer sensorNumber) {
        super(String.format("Sensor not found. parking id: %d, sensor number: %d", parkingId, sensorNumber));
    }
}

