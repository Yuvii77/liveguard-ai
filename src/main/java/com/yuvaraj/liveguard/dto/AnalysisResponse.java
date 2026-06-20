package com.yuvaraj.liveguard.dto;

public record AnalysisResponse(
        double riskScore,
        String riskLevel,
        String summary
) {
}