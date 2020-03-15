package ru.iopent.parking.endpoint;

import ru.iopent.parking.dto.parking.CreateParkingRequest;
import ru.iopent.parking.dto.parking.ParkingDto;

import java.util.List;

public interface ParkingEndpointService {
    ParkingDto findById(Integer id);
    ParkingDto createParking(CreateParkingRequest createParkingRequest);
    List<ParkingDto> findAll();
}
