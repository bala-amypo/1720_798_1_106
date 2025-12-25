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

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public String getSensorCode() {
        return sensorCode;
    }

    public void setSensorCode(String sensorCode) {
        this.sensorCode = sensorCode;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
