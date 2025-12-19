package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensors")
@Tag(name = "Sensors Endpoints")
public class SensorController {

    @PostMapping("/{locationId}")
    public String createSensor(@PathVariable Long locationId) {
        return "Sensor created for locationId: " + locationId;
    }

    @GetMapping
    public String listSensors() {
        return "List of sensors";
    }

    @GetMapping("/{id}")
    public String getSensor(@PathVariable Long id) {
        return "Sensor details for id: " + id;
    }
}
