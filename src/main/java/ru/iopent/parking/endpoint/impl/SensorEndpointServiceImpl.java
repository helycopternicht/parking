package ru.iopent.parking.endpoint.impl;

import org.springframework.stereotype.Service;
import ru.iopent.parking.dto.sensor.SensorDto;
import ru.iopent.parking.endpoint.SensorEndpointService;
import ru.iopent.parking.entity.Sensor;
import ru.iopent.parking.exception.ParkingNotFoundException;
import ru.iopent.parking.exception.SensorNotFoundException;
import ru.iopent.parking.mappers.SensorMapper;
import ru.iopent.parking.service.ParkingService;
import ru.iopent.parking.service.SensorService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorEndpointServiceImpl implements SensorEndpointService {
    private final SensorService sensorService;
    private final ParkingService parkingService;
    private final SensorMapper sensorMapper;

    public SensorEndpointServiceImpl(SensorService sensorService, ParkingService parkingService, SensorMapper sensorMapper) {
        this.sensorService = sensorService;
        this.parkingService = parkingService;
        this.sensorMapper = sensorMapper;
    }

    @Override
    public List<SensorDto> findAll(Integer parkingId) {
        return sensorService.findAllByParkingId(parkingId).stream()
                .map(sensorMapper::convertToSensorDto)
                .collect(Collectors.toList());
    }

    @Override
    public SensorDto findByParkingIdAndNumber(Integer parkingId, Integer number) {
        if (!parkingService.existById(parkingId)) {
            throw new ParkingNotFoundException(parkingId);
        }
        Sensor sensor = sensorService.findByParkingIdAndNumber(parkingId, number)
                .orElseThrow(() -> new SensorNotFoundException(parkingId, number));

        return sensorMapper.convertToSensorDto(sensor);
    }

    @Override
    public SensorDto setSensorBusy(Integer parkingId, Integer number) {
        if (!parkingService.existById(parkingId)) {
            throw new ParkingNotFoundException(parkingId);
        }
        Sensor sensor = sensorService.findByParkingIdAndNumber(parkingId, number)
                .orElseThrow(() -> new SensorNotFoundException(parkingId, number));

        sensor.setBusy(true);
        sensor = sensorService.save(sensor);
        return sensorMapper.convertToSensorDto(sensor);
    }

    @Override
    public SensorDto setSensorFree(Integer parkingId, Integer number) {
        if (!parkingService.existById(parkingId)) {
            throw new ParkingNotFoundException(parkingId);
        }
        Sensor sensor = sensorService.findByParkingIdAndNumber(parkingId, number)
                .orElseThrow(() -> new SensorNotFoundException(parkingId, number));

        sensor.setBusy(false);
        sensor = sensorService.save(sensor);
        return sensorMapper.convertToSensorDto(sensor);
    }
}
