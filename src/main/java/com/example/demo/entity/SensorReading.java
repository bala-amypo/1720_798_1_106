package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SensorReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Sensor sensor;

    private Double readingValue;
    private LocalDateTime readingTime;
    private String status;

    public Double getReadingValue() {
        return readingValue;
    }

    public LocalDateTime getReadingTime() {
        return readingTime;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
