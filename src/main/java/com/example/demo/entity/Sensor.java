package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String sensorType;

    @ManyToOne(optional = false)
    private Location location;

    @OneToMany(mappedBy = "sensor")
    private List<SensorReading> readings;

    // Getters & Setters
    public Long getId() { return id; }

    public String getSensorType() { return sensorType; }
    public void setSensorType(String sensorType) { this.sensorType = sensorType; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

    public List<SensorReading> getReadings() { return readings; }
    public void setReadings(List<SensorReading> readings) { this.readings = readings; }
}
