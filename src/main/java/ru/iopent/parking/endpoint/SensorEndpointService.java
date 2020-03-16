package ru.iopent.parking.endpoint;

import ru.iopent.parking.dto.sensor.SensorDto;

public interface SensorEndpointService {
    SensorDto setSensorBusy(Integer parkingId, Integer number);
    SensorDto setSensorFree(Integer parkingId, Integer number);
}
