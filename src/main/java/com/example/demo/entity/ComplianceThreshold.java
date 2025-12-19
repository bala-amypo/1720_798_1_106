package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ComplianceThreshold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sensorType;
    private Double minValue;
    private Double maxValue;
    private String severityLevel;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Double getMinValue() {
        return minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }
}
