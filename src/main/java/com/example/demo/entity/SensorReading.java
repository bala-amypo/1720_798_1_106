package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SensorReading {

    @Id
    @GeneratedValue
    private Long id;

    private Double readingValue;

    private String status;

    private LocalDateTime readingTime = LocalDateTime.now();

    @ManyToOne
    private Sensor sensor;

    // getters & setters
}
