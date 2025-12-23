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

    @PostMapping
    public ComplianceThreshold createThreshold(@RequestBody ComplianceThreshold threshold) {
        return complianceThresholdService.createThreshold(threshold);
    }

    @GetMapping
    public List<ComplianceThreshold> listThresholds() {
        return complianceThresholdService.getAllThresholds();
    }

    @GetMapping("/{id}")
    public ComplianceThreshold getThreshold(@PathVariable Long id) {
        return complianceThresholdService.getThreshold(id);
    }

    @GetMapping("/type/{sensorType}")
    public ComplianceThreshold getThresholdBySensorType(@PathVariable String sensorType) {
        return complianceThresholdService.getThresholdBySensorType(sensorType);
    }
}
