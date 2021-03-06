package ru.iopent.parking.endpoint.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.iopent.parking.dto.parking.CreateParkingRequest;
import ru.iopent.parking.dto.parking.FreeSlotsCountDto;
import ru.iopent.parking.dto.parking.FreeSlotsDto;
import ru.iopent.parking.dto.parking.ParkingDto;
import ru.iopent.parking.endpoint.ParkingEndpointService;
import ru.iopent.parking.entity.Parking;
import ru.iopent.parking.exception.ParkingNotFoundException;
import ru.iopent.parking.service.ParkingService;
import ru.iopent.parking.service.SensorService;

@Service
public class ParkingEndpointServiceImpl implements ParkingEndpointService {

    private final ParkingService parkingService;
    private final SensorService sensorService;

    public ParkingEndpointServiceImpl(ParkingService parkingService, SensorService sensorService) {
        this.parkingService = parkingService;
        this.sensorService = sensorService;
    }

    @Override
    @Transactional
    public ParkingDto createParking(@NonNull CreateParkingRequest createParkingRequest) {
        Parking parking = parkingService.createParking(createParkingRequest);
        sensorService.createSensors(parking.getCapacity(), parking.getId());
        return new ParkingDto(parking.getId(), parking.getDescription(), parking.getCapacity());
    }

    @Override
    public FreeSlotsDto hasAvailableSlots(@NonNull Integer id) {
        Parking parking = parkingService.findById(id).orElseThrow((() -> new ParkingNotFoundException(id)));
        return new FreeSlotsDto(sensorService.getFreeSensorCount(parking) > 0);
    }

    @Override
    public FreeSlotsCountDto getAvailableSlotsCount(@NonNull Integer id) {
        Parking parking = parkingService.findById(id).orElseThrow((() -> new ParkingNotFoundException(id)));
        return new FreeSlotsCountDto(sensorService.getFreeSensorCount(parking));
    }
}
