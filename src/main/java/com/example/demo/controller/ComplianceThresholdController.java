package com.example.demo.controller;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.service.ComplianceThresholdService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/thresholds")
@Tag(name = "Thresholds Endpoints")
public class ComplianceThresholdController {

    private final ComplianceThresholdService thresholdService;

    public ComplianceThresholdController(ComplianceThresholdService thresholdService) {
        this.thresholdService = thresholdService;
    }

    // ✅ Create a new threshold
    @PostMapping
    public ResponseEntity<ComplianceThreshold> createThreshold(@RequestBody ComplianceThreshold threshold) {
        threshold.setCreatedAt(LocalDateTime.now());
        ComplianceThreshold created = thresholdService.createThreshold(threshold);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // ✅ List all thresholds
    @GetMapping
    public ResponseEntity<List<ComplianceThreshold>> listThresholds() {
        List<ComplianceThreshold> thresholds = thresholdService.getAllThresholds();
        return new ResponseEntity<>(thresholds, HttpStatus.OK);
    }

    // ✅ Get threshold by ID
    @GetMapping("/{id}")
    public ResponseEntity<ComplianceThreshold> getThreshold(@PathVariable Long id) {
        ComplianceThreshold threshold = thresholdService.getThreshold(id);
        return new ResponseEntity<>(threshold, HttpStatus.OK);
    }

    // ✅ Get threshold by sensor type
    @GetMapping("/type/{sensorType}")
    public ResponseEntity<ComplianceThreshold> getThresholdBySensorType(@PathVariable String sensorType) {
        ComplianceThreshold threshold = thresholdService.getThresholdBySensorType(sensorType);
        return new ResponseEntity<>(threshold, HttpStatus.OK);
    }
}
