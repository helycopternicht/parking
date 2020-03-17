package ru.iopent.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iopent.parking.entity.Sensor;

import java.util.Optional;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    Optional<Sensor> findByParkingIdAndNumber(Integer parkingId, Integer number);
    Integer countAllByParkingIdAndBusy(Integer parkingId, Boolean isBusy);
}
