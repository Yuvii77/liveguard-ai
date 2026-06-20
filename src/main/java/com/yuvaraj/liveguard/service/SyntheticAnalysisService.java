package com.yuvaraj.liveguard.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yuvaraj.liveguard.dto.SyntheticResponse;

@Service
public class SyntheticAnalysisService {

    private static final String UPLOAD_DIR =
            "D:/Downloads/liveguardd/liveguard/uploads";

    private final PythonAiClientService pythonAiClientService;

    public SyntheticAnalysisService(
            PythonAiClientService pythonAiClientService
    ) {
        this.pythonAiClientService = pythonAiClientService;
    }

    public SyntheticResponse analyze(
            MultipartFile video
    ) {

        try {

            File directory = new File(UPLOAD_DIR);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            String fileName = video.getOriginalFilename();

            File destination = new File(directory, fileName);

            destination.getParentFile().mkdirs();

            video.transferTo(destination);

            return pythonAiClientService
                    .analyzeSynthetic(
                            destination.getAbsolutePath()
                    );

        } catch (IOException e) {

            return new SyntheticResponse(
                    0,
                    "ERROR",
                    e.getMessage()
            );
        }
    }
}