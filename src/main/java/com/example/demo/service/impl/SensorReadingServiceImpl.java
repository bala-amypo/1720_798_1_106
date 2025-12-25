package com.example.demo.service.impl;

import com.example.demo.entity.Sensor;
import com.example.demo.entity.SensorReading;
import com.example.demo.repository.SensorReadingRepository;
import com.example.demo.repository.SensorRepository;
import com.example.demo.service.SensorReadingService;
import org.springframework.stereotype.Service;

@Service
public class SensorReadingServiceImpl implements SensorReadingService {

    private final SensorReadingRepository readingRepo;
    private final SensorRepository sensorRepo;

    public SensorReadingServiceImpl(SensorReadingRepository readingRepo,
                                    SensorRepository sensorRepo) {
        this.readingRepo = readingRepo;
        this.sensorRepo = sensorRepo;
    }

    // ✅ METHOD 1 (already required)
    @Override
    public SensorReading submitReading(Long sensorId, SensorReading reading) {
        Sensor sensor = sensorRepo.findById(sensorId)
                .orElseThrow(() -> new RuntimeException("Sensor not found"));

        reading.setSensor(sensor);
        return readingRepo.save(reading);
    }

    // ✅ METHOD 2 (THIS WAS MISSING)
    @Override
    public SensorReading getReading(Long id) {
        return readingRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reading not found"));
    }
}
