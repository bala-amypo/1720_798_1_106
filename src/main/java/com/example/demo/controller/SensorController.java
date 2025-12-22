package com.example.demo.controller;

import com.example.demo.entity.Sensor;
import com.example.demo.service.SensorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
@Tag(name = "Sensors Endpoints")
public class SensorController {

    private final SensorService service;

    public SensorController(SensorService service) {
        this.service = service;
    }

    // ✅ CREATE sensor for a location
    @PostMapping("/{locationId}")
    public Sensor createSensor(@PathVariable Long locationId,
                               @RequestBody Sensor sensor) {
        return service.createSensor(locationId, sensor);
    }

    // ✅ GET all sensors
    @GetMapping
    public List<Sensor> getAllSensors() {
        return service.getAllSensors();
    }
}
