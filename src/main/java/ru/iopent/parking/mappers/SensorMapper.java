package ru.iopent.parking.mappers;

import ru.iopent.parking.dto.sensor.SensorDto;
import ru.iopent.parking.entity.Sensor;

public interface SensorMapper {
    SensorDto convertToSensorDto(Sensor sensor);
}
