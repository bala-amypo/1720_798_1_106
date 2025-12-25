package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ComplianceLog {

    @Id
    @GeneratedValue
    private Long id;

    private String statusAssigned;

    private LocalDateTime loggedAt;

    @OneToOne
    private SensorReading sensorReading;

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public SensorReading getSensorReading() {
        return sensorReading;
    }

    public void setSensorReading(SensorReading sensorReading) {
        this.sensorReading = sensorReading;
    }

    public String getStatusAssigned() {
        return statusAssigned;
    }

    public void setStatusAssigned(String statusAssigned) {
        this.statusAssigned = statusAssigned;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }
}
