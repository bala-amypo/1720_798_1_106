package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.ComplianceEvaluationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComplianceEvaluationServiceimpl
        implements ComplianceEvaluationService {

    private final SensorReadingRepository sensorReadingRepository;
    private final ComplianceThresholdRepository complianceThresholdRepository;
    private final ComplianceLogRepository complianceLogRepository;

    public ComplianceEvaluationServiceimpl(
            SensorReadingRepository sensorReadingRepository,
            ComplianceThresholdRepository complianceThresholdRepository,
            ComplianceLogRepository complianceLogRepository) {

        this.sensorReadingRepository = sensorReadingRepository;
        this.complianceThresholdRepository = complianceThresholdRepository;
        this.complianceLogRepository = complianceLogRepository;
    }

    @Override
    public void evaluateReading(Long readingId) {

        SensorReading reading = sensorReadingRepository.findById(readingId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("reading not found"));

        ComplianceThreshold threshold =
                complianceThresholdRepository.findBySensorType(
                        reading.getSensor().getSensorType());

        if (threshold == null) {
            throw new ResourceNotFoundException("threshold not found");
        }

        String status =
                (reading.getReadingValue() >= threshold.getMinValue()
                        && reading.getReadingValue() <= threshold.getMaxValue())
                        ? "PASS" : "FAIL";

        ComplianceLog log = new ComplianceLog();
        log.setSensorReading(reading);
        log.setThresholdUsed(threshold);
        log.setStatusAssigned(status);
        log.setRemarks("Auto evaluated");
        log.setLoggedAt(LocalDateTime.now());

        complianceLogRepository.save(log);

        reading.setStatus(status);
        sensorReadingRepository.save(reading);
    }

    @Override
    public List<ComplianceLog> getLogsByReading(Long readingId) {
        return complianceLogRepository.findBySensorReading_Id(readingId);
    }

    @Override
    public ComplianceLog getLog(Long id) {
        return complianceLogRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("log not found"));
    }
}
