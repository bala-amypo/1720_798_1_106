package com.example.demo.controller;

import com.example.demo.entity.Sensor;
import com.example.demo.service.SensorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    private final SensorService service;

    public SensorController(SensorService service) {
        this.service = service;
    }

    @PostMapping
    public Sensor create(@RequestBody Sensor sensor) {
        return service.create(sensor);
    }

    @GetMapping
    public List<Sensor> getAll() {
        return service.getAll();
    }
}
