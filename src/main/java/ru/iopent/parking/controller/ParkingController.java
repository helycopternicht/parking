package ru.iopent.parking.controller;

import org.springframework.web.bind.annotation.*;
import ru.iopent.parking.dto.parking.CreateParkingRequest;
import ru.iopent.parking.dto.parking.FreeSlotsCountDto;
import ru.iopent.parking.dto.parking.FreeSlotsDto;
import ru.iopent.parking.dto.parking.ParkingDto;
import ru.iopent.parking.endpoint.ParkingEndpointService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/parkings")
class ParkingController {
    private final ParkingEndpointService endpointService;

    ParkingController(ParkingEndpointService endpointService) {
		this.endpointService = endpointService;
	}

    @PostMapping
	public ParkingDto createParking(@RequestBody @Valid CreateParkingRequest createParkingRequest) {
        return endpointService.createParking(createParkingRequest);
	}

	@GetMapping("/{id:[\\d]+}/has-available-slots")
    public FreeSlotsDto hasAvailableSlots(@PathVariable Integer id) {
        return endpointService.hasAvailableSlots(id);
    }

    @GetMapping("/{id:[\\d]+}/available-slots-count")
    public FreeSlotsCountDto getAvailableSlotsCount(@PathVariable Integer id) {
        return endpointService.getAvailableSlotsCount(id);
    }
}