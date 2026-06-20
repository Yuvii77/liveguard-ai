package com.yuvaraj.liveguard.dto;

public class DeepfakeResponse {

    private int riskScore;
    private String riskLevel;
    private String summary;

    public DeepfakeResponse(int riskScore, String riskLevel, String summary) {
        this.riskScore = riskScore;
        this.riskLevel = riskLevel;
        this.summary = summary;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public String getSummary() {
        return summary;
    }
}