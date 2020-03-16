package ru.iopent.parking.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import ru.iopent.parking.entity.Parking;
import ru.iopent.parking.entity.Sensor;
import ru.iopent.parking.repository.ParkingRepository;
import ru.iopent.parking.repository.SensorRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SensorControllerTest extends ApiTestBase {

    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    private SensorRepository sensorRepository;

    @Test
    void setSensorBusy_WhenSensorNotFoundByNumber_ShouldReturn_422StatusCode() throws Exception {
        getMvc().perform(get(String.format("/api/parkings/%d/sensors/%d/busy", 1, 1))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void setSensorBusy_WhenDataPassedFromClientIsValid_ShouldReturn_200StatusCode() throws Exception {
        Parking parking = new Parking();
        parking.setId(1);
        parking.setDescription("Description");
        parking.setCapacity(1);
        parkingRepository.save(parking);

        Sensor sensor = new Sensor();
        sensor.setParkingId(parking.getId());
        sensor.setNumber(1);
        sensor.setBusy(false);
        sensor = sensorRepository.save(sensor);

        getMvc().perform(post(String.format("/api/parkings/%d/sensors/%d/busy", parking.getId(), sensor.getNumber()))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value(sensor.getNumber()))
                .andExpect(jsonPath("$.busy").value(true));
    }

    @Test
    void setSensorFree_WhenSensorNotFoundByNumber_ShouldReturn_422StatusCode() throws Exception {
        getMvc().perform(get(String.format("/api/parkings/%d/sensors/%d/free", 1, 1))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void setSensorFree_WhenDataPassedFromClientIsValid_ShouldReturn_200StatusCode() throws Exception {
        Parking parking = new Parking();
        parking.setId(1);
        parking.setDescription("Description");
        parking.setCapacity(1);
        parkingRepository.save(parking);

        Sensor sensor = new Sensor();
        sensor.setParkingId(parking.getId());
        sensor.setNumber(1);
        sensor.setBusy(true);
        sensor = sensorRepository.save(sensor);

        getMvc().perform(post(String.format("/api/parkings/%d/sensors/%d/free", parking.getId(), sensor.getNumber()))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value(sensor.getNumber()))
                .andExpect(jsonPath("$.busy").value(false));
    }

}
