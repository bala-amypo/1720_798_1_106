package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.entity.Sensor;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.SensorRepository;
import com.example.demo.service.SensorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceimpl implements SensorService {

    private final SensorRepository sensorRepository;
    private final LocationRepository locationRepository;

    public SensorServiceimpl(SensorRepository sensorRepository,
                             LocationRepository locationRepository) {
        this.sensorRepository = sensorRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public Sensor createSensor(Long locationId, Sensor sensor) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new RuntimeException("Location not found"));

        sensor.setLocation(location);
        return sensorRepository.save(sensor);
    }

    // ✅ MISSING METHOD — NOW ADDED
    @Override
    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }
}
