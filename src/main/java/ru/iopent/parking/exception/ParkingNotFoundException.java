package ru.iopent.parking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ParkingNotFoundException extends EntityNotFoundException {
    public ParkingNotFoundException(Integer id) {
        super("Parking not found. ID: " + id);
    }
}
