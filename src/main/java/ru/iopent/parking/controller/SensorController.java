package ru.iopent.parking.controller;

import org.springframework.web.bind.annotation.*;
import ru.iopent.parking.dto.sensor.SensorDto;
import ru.iopent.parking.endpoint.SensorEndpointService;

import java.util.List;

@RestController
@RequestMapping("/api/parkings/{parkingId}/sensors")
public class SensorController {
    private final SensorEndpointService sensorEndpointService;

    public SensorController(SensorEndpointService sensorEndpointService) {
        this.sensorEndpointService = sensorEndpointService;
    }

    @GetMapping
    public List<SensorDto> findAll(@PathVariable Integer parkingId) {
        return sensorEndpointService.findAll(parkingId);
    }

    @GetMapping("/{number}")
    public SensorDto findByNumber(@PathVariable Integer parkingId, @PathVariable Integer number) {
        return sensorEndpointService.findByParkingIdAndNumber(parkingId, number);
    }

    @PostMapping("/{number}/busy")
    public SensorDto setSensorBusy(@PathVariable Integer parkingId, @PathVariable Integer number) {
        return sensorEndpointService.setSensorBusy(parkingId, number);
    }

    @PostMapping("/{number}/free")
    public SensorDto setSensorFree(@PathVariable Integer parkingId, @PathVariable Integer number) {
        return sensorEndpointService.setSensorFree(parkingId, number);
    }

}
