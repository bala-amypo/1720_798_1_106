package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/thresholds")
@Tag(name = "Thresholds Endpoints")
public class ComplianceThresholdController {

    @PostMapping
    public String createThreshold() {
        return "Threshold created";
    }

    @GetMapping
    public String listThresholds() {
        return "List of thresholds";
    }

    @GetMapping("/{id}")
    public String getThreshold(@PathVariable Long id) {
        return "Threshold details for id: " + id;
    }

    @GetMapping("/type/{sensorType}")
    public String getThresholdBySensorType(@PathVariable String sensorType) {
        return "Threshold for sensor type: " + sensorType;
    }
}
