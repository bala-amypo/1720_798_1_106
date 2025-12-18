package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "sensors", uniqueConstraints = @UniqueConstraint(columnNames = "sensorCode"))
public class Sensor {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(nullable = false, unique = true)
private String sensorCode;


@Column(nullable = false)
private String sensorType;


@ManyToOne
@JoinColumn(name = "location_id", nullable = false)
private Location location;


private LocalDateTime installedAt = LocalDateTime.now();


private Boolean isActive = true;


}