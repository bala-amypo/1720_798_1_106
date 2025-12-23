package com.example.demo.service.impl;

import com.example.demo.entity.SensorReading;
import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.repository.SensorReadingRepository;
import com.example.demo.service.SensorReadingService;
import com.example.demo.service.ComplianceThresholdService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SensorReadingServiceImpl implements SensorReadingService {

    private final SensorReadingRepository sensorReadingRepository;
    private final ComplianceThresholdService complianceThresholdService;

    public SensorReadingServiceImpl(SensorReadingRepository sensorReadingRepository,
                                    ComplianceThresholdService complianceThresholdService) {
        this.sensorReadingRepository = sensorReadingRepository;
        this.complianceThresholdService = complianceThresholdService;
    }

    @Override
    public SensorReading submitReading(Long sensorId, SensorReading reading) {
        // 1️⃣ Assign sensorId
        reading.getSensor().setId(sensorId);

        // 2️⃣ Set reading time if not set
        if (reading.getReadingTime() == null) {
            reading.setReadingTime(LocalDateTime.now());
        }

        // 3️⃣ Get threshold for this sensor type
        ComplianceThreshold threshold = complianceThresholdService
                .getThresholdBySensorType(reading.getSensor().getSensorType());

        // 4️⃣ Check compliance
        if (reading.getReadingValue() >= threshold.getMinValue() &&
            reading.getReadingValue() <= threshold.getMaxValue()) {
            reading.setStatus("COMPLIANT");
        } else {
            reading.setStatus("NON-COMPLIANT");
        }

        // 5️⃣ Save and return
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
