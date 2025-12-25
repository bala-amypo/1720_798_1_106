package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ComplianceLog {

    @Id
    @GeneratedValue
    private Long id;

    private String statusAssigned;

    @OneToOne
    private SensorReading sensorReading;

    // getters & setters
}
