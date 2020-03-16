package ru.iopent.parking.endpoint;

import ru.iopent.parking.dto.parking.CreateParkingRequest;
import ru.iopent.parking.dto.parking.FreeSlotsCountDto;
import ru.iopent.parking.dto.parking.FreeSlotsDto;
import ru.iopent.parking.dto.parking.ParkingDto;

public interface ParkingEndpointService {
    ParkingDto createParking(CreateParkingRequest createParkingRequest);
    FreeSlotsDto hasAvailableSlots(Integer id);
    FreeSlotsCountDto getAvailableSlotsCount(Integer id);
}
