package com.yuvaraj.liveguard.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yuvaraj.liveguard.dto.DeepfakeResponse;
import com.yuvaraj.liveguard.service.DeepfakeService;

@RestController
public class AnalysisController {

    private final DeepfakeService deepfakeService;

    public AnalysisController(DeepfakeService deepfakeService) {
        this.deepfakeService = deepfakeService;
    }

    @PostMapping("/analyze/deepfake")
    public DeepfakeResponse analyzeDeepfake(
            @RequestParam("video") MultipartFile video
    ) {
        return deepfakeService.analyze(video);
    }
}