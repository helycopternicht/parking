package ru.iopent.parking.service;

import ru.iopent.parking.entity.Sensor;

import java.util.List;
import java.util.Optional;

public interface SensorService {
    List<Sensor> findAllByParkingId(Integer parkingId);
    List<Sensor> createSensors(Integer count, Integer parkingId);
    Optional<Sensor> findByParkingIdAndNumber(Integer parkingId, Integer number);
    Sensor save(Sensor sensor);
}
