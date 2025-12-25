package com.example.demo.service.impl;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ComplianceThresholdRepository;
import com.example.demo.service.ComplianceThresholdService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComplianceThresholdServiceImpl implements ComplianceThresholdService {

    private final ComplianceThresholdRepository complianceThresholdRepository;

    public ComplianceThresholdServiceImpl(ComplianceThresholdRepository complianceThresholdRepository) {
        this.complianceThresholdRepository = complianceThresholdRepository;
    }

    @Override
    public ComplianceThreshold createThreshold(ComplianceThreshold threshold) {
        threshold.setCreatedAt(LocalDateTime.now());
        return complianceThresholdRepository.save(threshold);
    }

    @Override
    public ComplianceThreshold getThreshold(Long id) {
        return complianceThresholdRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Threshold not found with id: " + id));
    }

    @Override
    public ComplianceThreshold getThresholdBySensorType(String sensorType) {
        return complianceThresholdRepository.findBySensorType(sensorType)
                .orElseThrow(() -> new ResourceNotFoundException("Threshold not found for sensor type: " + sensorType));
    }

    @Override
    public List<ComplianceThreshold> getAllThresholds() {
        return complianceThresholdRepository.findAll();
    }

    @Override
    public ComplianceThreshold updateThreshold(Long id, ComplianceThreshold updatedThreshold) {
        ComplianceThreshold existing = getThreshold(id);
        existing.setSensorType(updatedThreshold.getSensorType());
        existing.setMinValue(updatedThreshold.getMinValue());
        existing.setMaxValue(updatedThreshold.getMaxValue());
        existing.setSeverityLevel(updatedThreshold.getSeverityLevel());
        return complianceThresholdRepository.save(existing);
    }

    @Override
    public void deleteThreshold(Long id) {
        ComplianceThreshold existing = getThreshold(id);
        complianceThresholdRepository.delete(existing);
    }
}
