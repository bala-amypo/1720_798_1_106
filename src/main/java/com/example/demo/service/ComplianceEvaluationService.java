package com.example.demo.service;

import com.example.demo.entity.ComplianceLog;
import java.util.List;

public interface ComplianceEvaluationService {

    void evaluateReading(Long readingId);

    List<ComplianceLog> getLogsByReading(Long readingId);

    ComplianceLog getLog(Long id);
}
