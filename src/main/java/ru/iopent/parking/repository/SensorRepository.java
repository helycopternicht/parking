package ru.iopent.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iopent.parking.entity.Sensor;

import java.util.List;
import java.util.Optional;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    List<Sensor> findByParkingId(Integer parkingId);
    Optional<Sensor> findByParkingIdAndNumber(Integer parkingId, Integer number);
}
