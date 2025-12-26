package com.example.demo.service.impl;

import com.example.demo.entity.SensorReading;
import com.example.demo.repository.SensorReadingRepository;
import com.example.demo.service.SensorReadingService;
import org.springframework.stereotype.Service;

@Service
public class SensorReadingServiceImpl implements SensorReadingService {

    private final SensorReadingRepository repository;

    public SensorReadingServiceImpl(SensorReadingRepository repository) {
        this.repository = repository;
    }

    @Override
    public SensorReading save(SensorReading reading) {
        return repository.save(reading);
    }
}
