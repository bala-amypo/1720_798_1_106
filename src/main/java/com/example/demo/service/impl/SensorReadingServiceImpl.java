package com.example.demo.service.impl;

import com.example.demo.entity.Sensor;
import com.example.demo.entity.SensorReading;
import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.repository.SensorReadingRepository;
import com.example.demo.repository.SensorRepository;
import com.example.demo.service.SensorReadingService;
import com.example.demo.service.ComplianceThresholdService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SensorReadingServiceimpl implements SensorReadingService {

    private final SensorReadingRepository sensorReadingRepository;
    private final ComplianceThresholdService complianceThresholdService;
    private final SensorRepository sensorRepository;

    public SensorReadingServiceimpl(SensorReadingRepository sensorReadingRepository,
                                    ComplianceThresholdService complianceThresholdService,
                                    SensorRepository sensorRepository) {
        this.sensorReadingRepository = sensorReadingRepository;
        this.complianceThresholdService = complianceThresholdService;
        this.sensorRepository = sensorRepository;
    }

    @Override
    public SensorReading submitReading(Long sensorId, SensorReading reading) {
        // Get sensor
        Sensor sensor = sensorRepository.findById(sensorId)
                .orElseThrow(() -> new RuntimeException("Sensor not found with id: " + sensorId));
        reading.setSensor(sensor);

        // Set reading time
        if (reading.getReadingTime() == null) {
            reading.setReadingTime(LocalDateTime.now());
        }

        // Get threshold
        ComplianceThreshold threshold = complianceThresholdService.getThresholdBySensorType(sensor.getSensorType());

        // Set compliance status
        if (reading.getReadingValue() >= threshold.getMinValue() &&
            reading.getReadingValue() <= threshold.getMaxValue()) {
            reading.setStatus("COMPLIANT");
        } else {
            reading.setStatus("NON-COMPLIANT");
        }

        return sensorReadingRepository.save(reading);
    }

    @Override
    public SensorReading getReading(Long id) {
        return sensorReadingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reading not found with id: " + id));
    }

    @Override
    public List<SensorReading> getReadingsBySensor(Long sensorId) {
        return sensorReadingRepository.findBySensorId(sensorId);
    }
}
