package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private Long id;

    private String locationName;
    private String region;

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
