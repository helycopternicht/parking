package ru.iopent.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.iopent.parking.entity.Parking;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Integer> {
}
