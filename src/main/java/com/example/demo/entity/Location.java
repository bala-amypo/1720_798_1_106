package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private Long id;

    private String locationName;
    private String region;

    // getters & setters
}
