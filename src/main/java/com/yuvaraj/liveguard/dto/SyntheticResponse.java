package com.yuvaraj.liveguard.dto;

public class SyntheticResponse {

    private double riskScore;
    private String riskLevel;
    private String summary;

    public SyntheticResponse() {
    }

    public SyntheticResponse(double riskScore,
                             String riskLevel,
                             String summary) {
        this.riskScore = riskScore;
        this.riskLevel = riskLevel;
        this.summary = summary;
    }

    public double getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(double riskScore) {
        this.riskScore = riskScore;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}