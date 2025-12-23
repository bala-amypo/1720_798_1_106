package com.example.demo.controller;

import com.example.demo.entity.ComplianceThreshold;
import com.example.demo.service.ComplianceThresholdService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/thresholds")
@Tag(name = "Thresholds Endpoints")
public class ComplianceThresholdController {

    private final ComplianceThresholdService complianceThresholdService;

    public ComplianceThresholdController(ComplianceThresholdService complianceThresholdService) {
        this.complianceThresholdService = complianceThresholdService;
    }

    // ✅ Create a threshold
    @PostMapping
    public ComplianceThreshold createThreshold(@RequestBody ComplianceThreshold threshold) {
        return complianceThresholdService.createThreshold(threshold);
    }

    // ✅ List all thresholds
    @GetMapping
    public List<ComplianceThreshold> listThresholds() {
        return complianceThresholdService.getAllThresholds();
    }

    // ✅ Get threshold by ID
    @GetMapping("/{id}")
    public ComplianceThreshold getThreshold(@PathVariable Long id) {
        return complianceThresholdService.getThreshold(id);
    }

    // ✅ Get threshold by sensor type
    @GetMapping("/type/{sensorType}")
    public ComplianceThreshold getThresholdBySensorType(@PathVariable String sensorType) {
        return complianceThresholdService.getThresholdBySensorType(sensorType);
    }

    // ✅ Update threshold
    @PutMapping("/{id}")
    public ComplianceThreshold updateThreshold(@PathVariable Long id, @RequestBody ComplianceThreshold threshold) {
        return complianceThresholdService.updateThreshold(id, threshold);
    }

    // ✅ Delete threshold
    @DeleteMapping("/{id}")
    public String deleteThreshold(@PathVariable Long id) {
        complianceThresholdService.deleteThreshold(id);
        return "Threshold deleted successfully";
    }
}
