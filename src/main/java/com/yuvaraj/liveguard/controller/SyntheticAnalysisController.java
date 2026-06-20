package com.yuvaraj.liveguard.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yuvaraj.liveguard.dto.SyntheticResponse;
import com.yuvaraj.liveguard.service.SyntheticAnalysisService;

@RestController
@RequestMapping("/analyze")
@CrossOrigin("*")
public class SyntheticAnalysisController {

    private final SyntheticAnalysisService syntheticAnalysisService;

    public SyntheticAnalysisController(
            SyntheticAnalysisService syntheticAnalysisService
    ) {
        this.syntheticAnalysisService = syntheticAnalysisService;
    }

    @PostMapping("/synthetic")
    public SyntheticResponse analyzeSynthetic(
            @RequestParam("video") MultipartFile video
    ) {

        return syntheticAnalysisService.analyze(
                video
        );
    }
}