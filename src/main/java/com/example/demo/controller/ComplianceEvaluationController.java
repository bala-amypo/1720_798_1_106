package com.example.demo.controller;

import com.example.demo.entity.ComplianceLog;
import com.example.demo.service.ComplianceEvaluationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compliance")
@Tag(name = "Compliance Evaluation Endpoints")
public class ComplianceEvaluationController {

    private final ComplianceEvaluationService complianceEvaluationService;

    public ComplianceEvaluationController(
            ComplianceEvaluationService complianceEvaluationService) {
        this.complianceEvaluationService = complianceEvaluationService;
    }

    // 🔹 NO REQUEST BODY (CORRECT)
    @PostMapping("/evaluate/{readingId}")
    public String evaluate(@PathVariable Long readingId) {
        complianceEvaluationService.evaluateReading(readingId);
        return "Compliance evaluated for readingId: " + readingId;
    }

    // 🔹 THIS RETURNS JSON OUTPUT
    @GetMapping("/reading/{readingId}")
    public List<ComplianceLog> getLogs(@PathVariable Long readingId) {
        return complianceEvaluationService.getLogsByReading(readingId);
    }
}
