package com.example.demo.service;

import com.example.demo.entity.Sensor;
import com.example.demo.entity.SensorReading;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SensorReadingRepository;
import com.example.demo.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SensorReadingServiceimpl implements SensorReadingService {

    private final SensorReadingRepository readingRepository;
    private final SensorRepository sensorRepository;

    // ✅ Constructor order EXACT
    public SensorReadingServiceimpl(SensorReadingRepository readingRepository,
                                    SensorRepository sensorRepository) {
        this.readingRepository = readingRepository;
        this.sensorRepository = sensorRepository;
    }

    @Override
    public SensorReading submitReading(Long sensorId, SensorReading reading) {

        if (reading.getReadingValue() == null) {
            throw new IllegalArgumentException("readingvalue missing");
        }

        if (reading.getReadingTime().isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("future date not allowed");
        }

        Sensor sensor = sensorRepository.findById(sensorId)
                .orElseThrow(() -> new ResourceNotFoundException("Sensor not found"));

        reading.setSensor(sensor);
        return readingRepository.save(reading);
    }

    @Override
    public SensorReading getReading(Long id) {
        return readingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reading not found"));
    }

    @Override
    public List<SensorReading> getReadingsBySensor(Long sensorId) {
        return readingRepository.findBySensor_Id(sensorId);
    }
}
