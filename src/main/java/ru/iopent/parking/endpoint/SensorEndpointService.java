package ru.iopent.parking.endpoint;

import ru.iopent.parking.dto.sensor.SensorDto;

import java.util.List;

public interface SensorEndpointService {
    List<SensorDto> findAll(Integer parkingId);

    SensorDto findByParkingIdAndNumber(Integer parkingId, Integer number);

    SensorDto setSensorBusy(Integer parkingId, Integer number);

    SensorDto setSensorFree(Integer parkingId, Integer number);
}
