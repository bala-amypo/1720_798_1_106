package com.example.demo.service;

import com.example.demo.entity.ComplianceThreshold;
import java.util.List;

public interface ComplianceThresholdService {
    ComplianceThreshold createThreshold(ComplianceThreshold threshold);
    ComplianceThreshold getThresholdBySensorType(String sensorType);
    List<ComplianceThreshold> getAllThresholds();
}
