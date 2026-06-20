package com.yuvaraj.liveguard.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yuvaraj.liveguard.dto.ContextResponse;

@Service
public class ContextAnalysisService {

    private static final String UPLOAD_DIR =
            "D:/Downloads/liveguardd/liveguard/uploads";

    private final PythonAiClientService pythonAiClientService;

    public ContextAnalysisService(
            PythonAiClientService pythonAiClientService
    ) {
        this.pythonAiClientService = pythonAiClientService;
    }

    public ContextResponse analyze(
            MultipartFile video,
            String claim
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
                    .analyzeContext(
                            destination.getAbsolutePath(),
                            claim
                    );

        } catch (IOException e) {

            return new ContextResponse(
                    0,
                    "ERROR",
                    e.getMessage()
            );
        }
    }
}