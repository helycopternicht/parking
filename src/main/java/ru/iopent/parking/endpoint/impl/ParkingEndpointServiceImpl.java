package ru.iopent.parking.endpoint.impl;

import org.springframework.stereotype.Service;
import ru.iopent.parking.dto.CreateParkingRequest;
import ru.iopent.parking.dto.ParkingDto;
import ru.iopent.parking.endpoint.ParkingEndpointService;
import ru.iopent.parking.entity.Parking;
import ru.iopent.parking.exception.ParkingNotFoundException;
import ru.iopent.parking.mappers.ParkingMapper;
import ru.iopent.parking.service.ParkingService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingEndpointServiceImpl implements ParkingEndpointService {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingEndpointServiceImpl(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @Override
    public ParkingDto findById(Integer id) {
        Parking parking = parkingService.findById(id).orElseThrow((() -> new ParkingNotFoundException(id)));
        return parkingMapper.convertToParkingDto(parking);
    }

    @Override
    public ParkingDto createParking(CreateParkingRequest createParkingRequest) {
        Parking parking = parkingService.createParking(createParkingRequest);
        return parkingMapper.convertToParkingDto(parking);
    }

    @Override
    public List<ParkingDto> findAll() {
        return parkingService.findAll()
                .stream()
                .map(parkingMapper::convertToParkingDto)
                .collect(Collectors.toList());
    }
}
