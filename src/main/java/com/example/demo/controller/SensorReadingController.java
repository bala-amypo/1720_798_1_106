package com.example.demo.controller;

import com.example.demo.entity.SensorReading;
import com.example.demo.service.SensorReadingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/readings")
public class SensorReadingController {

    private final SensorReadingService sensorReadingService;

    public SensorReadingController(SensorReadingService sensorReadingService) {
        this.sensorReadingService = sensorReadingService;
    }

    @PostMapping("/{sensorId}")
    public SensorReading submitReading(
            @PathVariable Long sensorId,
            @RequestBody SensorReading reading) {

        return sensorReadingService.submitReading(sensorId, reading);
    }

    @GetMapping("/{readingId}")
    public SensorReading getReading(@PathVariable Long readingId) {
        return sensorReadingService.getReading(readingId);
    }
}
