package ru.iopent.parking.mappers.impl;

import org.springframework.stereotype.Service;
import ru.iopent.parking.dto.parking.ParkingDto;
import ru.iopent.parking.entity.Parking;
import ru.iopent.parking.mappers.ParkingMapper;

@Service
public class ParkingMapperImpl implements ParkingMapper {
    @Override
    public ParkingDto convertToParkingDto(Parking parking) {
        return new ParkingDto(parking.getId(), parking.getDescription(), parking.getCapacity());
    }
}