package ru.iopent.parking;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.iopent.parking.entity.Parking;
import ru.iopent.parking.repository.ParkingRepository;
import ru.iopent.parking.repository.SensorRepository;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TestsRequiredInTask {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ParkingRepository parkingRepository;

    @MockBean
    private SensorRepository sensorRepository;

    @Test
    void hasAvailableSlots_WhenThereIsNotParkingWithSpecifiedId_ShouldReturn_404StatusCode() throws Exception {
        Mockito.when(parkingRepository.findById(1)).thenReturn(Optional.empty());

        mvc.perform(get(String.format("/api/parkings/%d/has-available-slots", 1))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void hasAvailableSlots_WhenAtLeastOneSensorIsFree_ShouldReturn_isFreeSlotsAvailableEqualsToTrue() throws Exception {
        Parking parking = new Parking();
        parking.setId(1);
        parking.setDescription("Description");
        parking.setCapacity(2);

        Mockito.when(parkingRepository.findById(parking.getId())).thenReturn(Optional.of(parking));
        Mockito.when(sensorRepository.countAllByParkingIdAndBusy(parking.getId(), false)).thenReturn(1);

        mvc.perform(get(String.format("/api/parkings/%d/has-available-slots", parking.getId()))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.freeSlotsAvailable").value(true));
    }

    @Test
    void hasAvailableSlots_WhenNoOneSlotIsFree_ShouldReturn_isFreeSlotsAvailableEqualsToFalse() throws Exception {
        Parking parking = new Parking();
        parking.setId(1);
        parking.setDescription("Description");
        parking.setCapacity(2);

        Mockito.when(parkingRepository.findById(parking.getId())).thenReturn(Optional.of(parking));
        Mockito.when(sensorRepository.countAllByParkingIdAndBusy(parking.getId(), false)).thenReturn(0);

        mvc.perform(get(String.format("/api/parkings/%d/has-available-slots", parking.getId()))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.freeSlotsAvailable").value(false));
    }

}
