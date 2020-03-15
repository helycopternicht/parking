package ru.iopent.parking.mappers.impl;

import org.springframework.stereotype.Service;
import ru.iopent.parking.dto.ParkingDto;
import ru.iopent.parking.entity.Parking;
import ru.iopent.parking.mappers.ParkingMapper;

@Service
public class ParkingMapperImpl implements ParkingMapper {
    @Override
    public ParkingDto convertToParkingDto(Parking parking) {
        ParkingDto dto = new ParkingDto();
        dto.setId(parking.getId());
        dto.setDescription(parking.getDescription());
        dto.setCapacity(parking.getCapacity());
        dto.setCurrentFullness(parking.getCurrentFullness());
        return dto;
    }
}
