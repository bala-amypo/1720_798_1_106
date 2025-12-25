package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ComplianceThreshold {

    @Id
    @GeneratedValue
    private Long id;

    private String sensorType;
    private Double minValue;
    private Double maxValue;
    private String severityLevel;

    // getters & setters
}
