package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ComplianceLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String statusAssigned;

    @OneToOne
    private SensorReading sensorReading;

    public Long getId() { return id; }

    public String getStatusAssigned() { return statusAssigned; }
    public void setStatusAssigned(String statusAssigned) {
        this.statusAssigned = statusAssigned;
    }

    public SensorReading getSensorReading() { return sensorReading; }
    public void setSensorReading(SensorReading sensorReading) {
        this.sensorReading = sensorReading;
    }
}
