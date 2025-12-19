package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compliance")
@Tag(name = "Compliance Evaluation Endpoints")
public class ComplianceEvaluationController {

    @PostMapping("/evaluate/{readingId}")
    public String evaluateReading(@PathVariable Long readingId) {
        return "Compliance evaluated for readingId: " + readingId;
    }
}
