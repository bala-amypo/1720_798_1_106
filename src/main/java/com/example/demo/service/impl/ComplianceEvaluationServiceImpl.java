package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;

import java.util.List;

public class ComplianceEvaluationServiceImpl {

    private final SensorReadingRepository readingRepo;
    private final ComplianceThresholdRepository thresholdRepo;
    private final ComplianceLogRepository logRepo;

    public ComplianceEvaluationServiceImpl(
            SensorReadingRepository readingRepo,
            ComplianceThresholdRepository thresholdRepo,
            ComplianceLogRepository logRepo) {

        this.readingRepo = readingRepo;
        this.thresholdRepo = thresholdRepo;
        this.logRepo = logRepo;
    }

    public ComplianceLog evaluateReading(Long readingId) {

        SensorReading reading = readingRepo.findById(readingId)
                .orElseThrow(() -> new RuntimeException("not found"));

        List<ComplianceLog> existing =
                logRepo.findBySensorReading_Id(readingId);

        if (!existing.isEmpty()) {
            return existing.get(0);
        }

        ComplianceThreshold threshold =
                thresholdRepo.findBySensorType(
                        reading.getSensor().getSensorType())
                        .orElseThrow(() -> new RuntimeException("not found"));

        ComplianceLog log = new ComplianceLog();
        log.setSensorReading(reading);

        if (reading.getReadingValue() < threshold.getMinValue()
                || reading.getReadingValue() > threshold.getMaxValue()) {
            log.setStatusAssigned("UNSAFE");
            reading.setStatus("UNSAFE");
        } else {
            log.setStatusAssigned("SAFE");
            reading.setStatus("SAFE");
        }

        return logRepo.save(log);
    }
}
