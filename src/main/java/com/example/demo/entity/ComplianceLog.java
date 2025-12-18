package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "compliance_logs")
public class ComplianceLog {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@OneToOne
@JoinColumn(name = "sensor_reading_id", nullable = false)
private SensorReading sensorReading;


@ManyToOne
@JoinColumn(name = "threshold_id")
private ComplianceThreshold thresholdUsed;


private String statusAssigned;


private String remarks;


private LocalDateTime loggedAt = LocalDateTime.now();


// getters and setters
}