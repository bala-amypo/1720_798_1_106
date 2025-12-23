package com.example.demo.controller;

import com.example.demo.entity.SensorReading;
import com.example.demo.service.SensorReadingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readings")
@Tag(name = "Sensor Readings Endpoints")
public class SensorReadingController {

    private final SensorReadingService sensorReadingService;

    public SensorReadingController(SensorReadingService sensorReadingService) {
        this.sensorReadingService = sensorReadingService;
    }

    // Submit a new reading
    @PostMapping("/{sensorId}")
    public SensorReading submitReading(@PathVariable Long sensorId, @RequestBody SensorReading reading) {
        return sensorReadingService.submitReading(sensorId, reading);
    }

    // Get reading by id
    @GetMapping("/{id}")
    public SensorReading getReading(@PathVariable Long id) {
        return sensorReadingService.getReading(id);
    }

    // Get all readings of a sensor
    @GetMapping("/sensor/{sensorId}")
    public List<SensorReading> getReadingsBySensor(@PathVariable Long sensorId) {
        return sensorReadingService.getReadingsBySensor(sensorId);
    }
}
