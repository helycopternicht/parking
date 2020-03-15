package ru.iopent.parking.endpoint.impl;

import org.springframework.stereotype.Service;
import ru.iopent.parking.dto.parking.CreateParkingRequest;
import ru.iopent.parking.dto.parking.ParkingDto;
import ru.iopent.parking.endpoint.ParkingEndpointService;
import ru.iopent.parking.entity.Parking;
import ru.iopent.parking.exception.ParkingNotFoundException;
import ru.iopent.parking.mappers.ParkingMapper;
import ru.iopent.parking.service.ParkingService;
import ru.iopent.parking.service.SensorService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingEndpointServiceImpl implements ParkingEndpointService {

    private final ParkingService parkingService;
    private final SensorService sensorService;
    private final ParkingMapper parkingMapper;

    public ParkingEndpointServiceImpl(ParkingService parkingService, SensorService sensorService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.sensorService = sensorService;
        this.parkingMapper = parkingMapper;
    }

    @Override
    public ParkingDto findById(Integer id) {
        Parking parking = parkingService.findById(id).orElseThrow((() -> new ParkingNotFoundException(id)));
        return parkingMapper.convertToParkingDto(parking);
    }

    @Override
    // TODO: maybe need to make this method transactional???
    public ParkingDto createParking(CreateParkingRequest createParkingRequest) {
        Parking parking = parkingService.createParking(createParkingRequest);
        sensorService.createSensors(parking.getCapacity(), parking.getId());
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
