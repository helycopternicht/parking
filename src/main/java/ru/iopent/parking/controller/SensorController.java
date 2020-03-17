package ru.iopent.parking.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.iopent.parking.dto.sensor.SensorDto;
import ru.iopent.parking.endpoint.SensorEndpointService;

@RestController
@RequestMapping("/api/parkings/{parkingId:[\\d]+}/sensors")
public class SensorController {
    private final SensorEndpointService sensorEndpointService;

    public SensorController(SensorEndpointService sensorEndpointService) {
        this.sensorEndpointService = sensorEndpointService;
    }

    @PostMapping("/{number:[\\d]+}/busy")
    public SensorDto setSensorBusy(@PathVariable Integer parkingId, @PathVariable Integer number) {
        return sensorEndpointService.setSensorBusy(parkingId, number);
    }

    @PostMapping("/{number:[\\d]+}/free")
    public SensorDto setSensorFree(@PathVariable Integer parkingId, @PathVariable Integer number) {
        return sensorEndpointService.setSensorFree(parkingId, number);
    }

}