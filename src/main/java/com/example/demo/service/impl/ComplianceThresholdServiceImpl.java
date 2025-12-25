package com.example.demo.service.impl;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.repository.ComplianceThresholdRepository;
import com.example.demo.service.ComplianceThresholdService;
import org.springframework.stereotype.Service;

@Service
public class ComplianceThresholdServiceImpl
        implements ComplianceThresholdService {

    private final ComplianceThresholdRepository repo;

    public ComplianceThresholdServiceImpl(ComplianceThresholdRepository repo) {
        this.repo = repo;
    }

    @Override
    public ComplianceThreshold createThreshold(ComplianceThreshold t) {
        if (t.getMinValue() >= t.getMaxValue()) {
            throw new IllegalArgumentException("minValue");
        }
        return repo.save(t);
    }

    @Override
    public ComplianceThreshold getThresholdBySensorType(String type) {
        return repo.findBySensorType(type)
                .orElseThrow(() -> new RuntimeException("not found"));
    }
}
