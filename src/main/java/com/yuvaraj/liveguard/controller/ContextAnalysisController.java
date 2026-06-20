package com.yuvaraj.liveguard.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yuvaraj.liveguard.dto.ContextResponse;
import com.yuvaraj.liveguard.service.ContextAnalysisService;

@RestController
@RequestMapping("/analyze")
@CrossOrigin("*")
public class ContextAnalysisController {

    private final ContextAnalysisService contextAnalysisService;

    public ContextAnalysisController(
            ContextAnalysisService contextAnalysisService
    ) {
        this.contextAnalysisService = contextAnalysisService;
    }

    @PostMapping("/context")
    public ContextResponse analyzeContext(
            @RequestParam("video") MultipartFile video,
            @RequestParam("claim") String claim
    ) {

        return contextAnalysisService.analyze(
                video,
                claim
        );
    }
}