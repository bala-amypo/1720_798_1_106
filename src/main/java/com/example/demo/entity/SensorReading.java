package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "sensor_readings")
public class SensorReading {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@ManyToOne
@JoinColumn(name = "sensor_id", nullable = false)
private Sensor sensor;


@Column(nullable = false)
private Double readingValue;


private LocalDateTime readingTime = LocalDateTime.now();


private String status;



}