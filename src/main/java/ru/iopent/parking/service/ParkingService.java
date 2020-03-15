package ru.iopent.parking.service;

import ru.iopent.parking.dto.parking.CreateParkingRequest;
import ru.iopent.parking.entity.Parking;

import java.util.List;
import java.util.Optional;

public interface ParkingService {
    Optional<Parking> findById(Integer id);
    Parking createParking(CreateParkingRequest createParkingRequest);
    List<Parking> findAll();
    Boolean existById(Integer parkingId);
}
