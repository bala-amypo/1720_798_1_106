package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Sensor {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String sensorCode;

    private String sensorType;

    private Boolean isActive = true;

    @ManyToOne
    private Location location;

    // getters & setters
}
