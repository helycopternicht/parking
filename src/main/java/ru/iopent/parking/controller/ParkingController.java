package ru.iopent.parking.controller;

import org.springframework.web.bind.annotation.*;
import ru.iopent.parking.dto.parking.CreateParkingRequest;
import ru.iopent.parking.dto.parking.ParkingDto;
import ru.iopent.parking.endpoint.ParkingEndpointService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/parkings")
class ParkingController {
    private final ParkingEndpointService endpointService;

    ParkingController(ParkingEndpointService endpointService) {
		this.endpointService = endpointService;
	}

    @GetMapping("/{id}")
    public ParkingDto findById(@PathVariable Integer id) {
        return endpointService.findById(id);
    }

    @PostMapping
	public ParkingDto create(@RequestBody @Valid CreateParkingRequest createParkingRequest) {
        return endpointService.createParking(createParkingRequest);
	}

	@GetMapping
    public List<ParkingDto> finAll() {
        return endpointService.findAll();
    }
}