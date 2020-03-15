package ru.iopent.parking.mappers;

import ru.iopent.parking.dto.ParkingDto;
import ru.iopent.parking.entity.Parking;

public interface ParkingMapper {
    ParkingDto convertToParkingDto(Parking parking);
}
