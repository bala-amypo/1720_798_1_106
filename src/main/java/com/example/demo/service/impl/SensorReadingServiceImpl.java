package com.example.demo.service.impl;

import com.example.demo.entity.Sensor;
import com.example.demo.entity.SensorReading;
import com.example.demo.repository.SensorReadingRepository;
import com.example.demo.repository.SensorRepository;
import com.example.demo.service.SensorReadingService;
import org.springframework.stereotype.Service;

@Service
public class SensorReadingServiceImpl implements SensorReadingService {

    private final SensorReadingRepository readingRepository;
    private final SensorRepository sensorRepository;

    public SensorReadingServiceImpl(
            SensorReadingRepository readingRepository,
            SensorRepository sensorRepository) {
        this.readingRepository = readingRepository;
        this.sensorRepository = sensorRepository;
    }

    @Override
    public SensorReading submitReading(Long sensorId, SensorReading reading) {
        Sensor sensor = sensorRepository.findById(sensorId)
                .orElseThrow(() -> new RuntimeException("Sensor not found"));

        reading.setSensor(sensor);
        return readingRepository.save(reading);
    }

    @Override
    public SensorReading getReading(Long readingId) {
        return readingRepository.findById(readingId)
                .orElseThrow(() -> new RuntimeException("Reading not found"));
    }
}
