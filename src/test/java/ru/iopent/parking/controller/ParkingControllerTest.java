package ru.iopent.parking.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import ru.iopent.parking.dto.parking.CreateParkingRequest;
import ru.iopent.parking.entity.Parking;
import ru.iopent.parking.entity.Sensor;
import ru.iopent.parking.repository.ParkingRepository;
import ru.iopent.parking.repository.SensorRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ParkingControllerTest extends ApiTestBase {

    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    private SensorRepository sensorRepository;

    @Test
    void createParking_WhenDtoIsValid_ShouldReturn_200StatusCode() throws Exception {
        CreateParkingRequest newParking = new CreateParkingRequest("New parking", 10);
        getMvc().perform(
                post("/api/parkings")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getObjectMapper().writeValueAsBytes(newParking)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.description").value(newParking.getDescription()))
                .andExpect(jsonPath("$.capacity").value(newParking.getCapacity()));
    }

    @Test
    void createParking_WhenDtoIsNotValid_ShouldReturn_422StatusCode() throws Exception {
        CreateParkingRequest newParking = new CreateParkingRequest("", 0);
        getMvc().perform(
                post("/api/parkings")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getObjectMapper().writeValueAsBytes(newParking)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void getAvailableSlotsCount_WhenThere1AvailableSlot_ShouldReturn_freeSlotsCountEqualsToOne() throws Exception {
        Parking parking = new Parking();
        parking.setDescription("Description");
        parking.setCapacity(2);
        parking = parkingRepository.save(parking);

        Sensor sensor = new Sensor();
        sensor.setParkingId(parking.getId());
        sensor.setNumber(1);
        sensor.setBusy(false);
        sensorRepository.save(sensor);

        getMvc().perform(get(String.format("/api/parkings/%d/available-slots-count", parking.getId()))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.freeSlotsCount").value(1));
    }
}