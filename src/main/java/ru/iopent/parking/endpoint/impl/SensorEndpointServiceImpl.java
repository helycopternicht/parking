package ru.iopent.parking.endpoint.impl;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.iopent.parking.dto.sensor.SensorDto;
import ru.iopent.parking.endpoint.SensorEndpointService;
import ru.iopent.parking.entity.Parking;
import ru.iopent.parking.entity.Sensor;
import ru.iopent.parking.exception.ParkingNotFoundException;
import ru.iopent.parking.exception.SensorNotFoundException;
import ru.iopent.parking.service.ParkingService;
import ru.iopent.parking.service.SensorService;

@Service
public class SensorEndpointServiceImpl implements SensorEndpointService {
    private final SensorService sensorService;
    private final ParkingService parkingService;

    public SensorEndpointServiceImpl(SensorService sensorService, ParkingService parkingService) {
        this.sensorService = sensorService;
        this.parkingService = parkingService;
    }

    @Override
    public SensorDto setSensorBusy(@NonNull Integer parkingId, @NonNull Integer number) {
        Parking parking = parkingService.findById(parkingId)
                .orElseThrow(() -> new ParkingNotFoundException(parkingId));

        Sensor sensor = sensorService.findByParkingAndNumber(parking, number)
                .orElseThrow(() -> new SensorNotFoundException(parkingId, number));

        sensor.setBusy(true);
        sensor = sensorService.save(sensor);
        return new SensorDto(sensor.getNumber(), sensor.getBusy());
    }

    @Override
    public SensorDto setSensorFree(@NonNull Integer parkingId, @NonNull Integer number) {
        Parking parking = parkingService.findById(parkingId)
                .orElseThrow(() -> new ParkingNotFoundException(parkingId));

        Sensor sensor = sensorService.findByParkingAndNumber(parking, number)
                .orElseThrow(() -> new SensorNotFoundException(parkingId, number));

        sensor.setBusy(false);
        sensor = sensorService.save(sensor);
        return new SensorDto(sensor.getNumber(), sensor.getBusy());
    }
}
