package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "compliance_thresholds", uniqueConstraints = @UniqueConstraint(columnNames = "sensorType"))
public class ComplianceThreshold {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(nullable = false, unique = true)
private String sensorType;


private Double minValue;
private Double maxValue;


@Column(nullable = false)
private String severityLevel;


private LocalDateTime createdAt = LocalDateTime.now();



}