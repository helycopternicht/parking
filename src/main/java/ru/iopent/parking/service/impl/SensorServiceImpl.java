package ru.iopent.parking.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.iopent.parking.entity.Sensor;
import ru.iopent.parking.repository.SensorRepository;
import ru.iopent.parking.service.SensorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SensorServiceImpl implements SensorService {
    private final SensorRepository sensorRepository;

    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sensor> findAllByParkingId(Integer parkingId) {
        return sensorRepository.findByParkingId(parkingId);
    }

    @Override
    @Transactional
    public List<Sensor> createSensors(Integer count, Integer parkingId) {
        List<Sensor> list = new ArrayList<>(count);
        for (int number = 1; number <= count; number++) {
            Sensor sensor = new Sensor();
            sensor.setNumber(number);
            sensor.setBusy(false);
            sensor.setParkingId(parkingId);
            list.add(sensorRepository.save(sensor));
        }
        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Sensor> findByParkingIdAndNumber(Integer parkingId, Integer number) {
        return sensorRepository.findByParkingIdAndNumber(parkingId, number);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Sensor save(Sensor sensor) {
        return sensorRepository.save(sensor);
    }
}
