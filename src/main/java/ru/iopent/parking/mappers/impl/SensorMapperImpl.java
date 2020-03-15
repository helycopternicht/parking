package ru.iopent.parking.mappers.impl;

import org.springframework.stereotype.Service;
import ru.iopent.parking.dto.sensor.SensorDto;
import ru.iopent.parking.entity.Sensor;
import ru.iopent.parking.mappers.SensorMapper;

@Service
public class SensorMapperImpl implements SensorMapper {
    @Override
    public SensorDto convertToSensorDto(Sensor sensor) {
        SensorDto dto = new SensorDto();
        dto.setNumber(sensor.getNumber());
        dto.setBusy(sensor.getBusy());
        return dto;
    }
}
