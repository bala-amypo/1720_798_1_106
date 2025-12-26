package com.example.demo.service.impl;

import com.example.demo.entity.Sensor;
import com.example.demo.repository.SensorRepository;
import com.example.demo.service.SensorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;

    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public Sensor create(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    @Override
    public List<Sensor> getAll() {
        return sensorRepository.findAll();
    }
}
