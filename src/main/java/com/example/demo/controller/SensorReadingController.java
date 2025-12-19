package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/readings")
@Tag(name = "Sensor Readings Endpoints")
public class SensorReadingController {

    @PostMapping("/{sensorId}")
    public String submitReading(@PathVariable Long sensorId) {
        return "Reading submitted for sensorId: " + sensorId;
    }

    @GetMapping("/sensor/{sensorId}")
    public String listReadingsBySensor(@PathVariable Long sensorId) {
        return "Readings for sensorId: " + sensorId;
    }

    @GetMapping("/{id}")
    public String getReading(@PathVariable Long id) {
        return "Reading details for id: " + id;
    }
}
