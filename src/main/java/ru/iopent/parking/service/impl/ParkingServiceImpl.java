package ru.iopent.parking.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.iopent.parking.dto.CreateParkingRequest;
import ru.iopent.parking.entity.Parking;
import ru.iopent.parking.repository.ParkingRepository;
import ru.iopent.parking.service.ParkingService;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingServiceImpl implements ParkingService {
    private final ParkingRepository parkingRepository;

    public ParkingServiceImpl(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Parking> findById(Integer id) {
        return parkingRepository.findById(id);
    }

    @Override
    @Transactional
    public Parking createParking(CreateParkingRequest createParkingRequest) {
        Parking parking = new Parking();
        parking.setDescription(createParkingRequest.getDescription());
        parking.setCapacity(createParkingRequest.getCapacity());
        parking.setCurrentFullness(0);
        return parkingRepository.save(parking);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Parking> findAll() {
        return parkingRepository.findAll();
    }
}