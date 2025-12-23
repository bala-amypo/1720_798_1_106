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

    private LocalDateTime createdAt;

    // getters and setters
}
