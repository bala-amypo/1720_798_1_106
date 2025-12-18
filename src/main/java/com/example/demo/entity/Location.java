package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "locations", uniqueConstraints = @UniqueConstraint(columnNames = "locationName"))
public class Location {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(nullable = false, unique = true)
private String locationName;


private String description;


@Column(nullable = false)
private String region;


private LocalDateTime createdAt = LocalDateTime.now();



}