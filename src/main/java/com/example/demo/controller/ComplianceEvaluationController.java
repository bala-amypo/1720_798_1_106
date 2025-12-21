package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compliance")
@Tag(name = "Compliance Evaluation Endpoints")
public class ComplianceEvaluationController {

    // POST: evaluate reading and create log
    @PostMapping("/evaluate/{readingId}")
    public String evaluateReading(@PathVariable Long readingId) {
        return "Compliance evaluated for readingId: " + readingId;
    }

    // GET: list logs for a reading
    @GetMapping("/reading/{readingId}")
    public String getLogsByReading(@PathVariable Long readingId) {
        return "Logs for readingId: " + readingId;
    }

    // GET: get single log by id
    @GetMapping("/{id}")
    public String getLogById(@PathVariable Long id) {
        return "Compliance log with id: " + id;
    }
}
