package ru.iopent.parking.service;

import ru.iopent.parking.entity.Parking;
import ru.iopent.parking.entity.Sensor;

import java.util.List;
import java.util.Optional;

public interface SensorService {
    List<Sensor> createSensors(Integer count, Integer parkingId);
    Optional<Sensor> findByParkingAndNumber(Parking parking, Integer number);
    Sensor save(Sensor sensor);
    Integer getFreeSensorCount(Parking parking);
}
