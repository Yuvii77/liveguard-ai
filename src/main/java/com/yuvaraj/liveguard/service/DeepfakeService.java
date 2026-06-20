package com.yuvaraj.liveguard.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yuvaraj.liveguard.dto.DeepfakeResponse;

@Service
public class DeepfakeService {

    private static final String UPLOAD_DIR =
            "D:/Downloads/liveguardd/liveguard/uploads";

    private final PythonAiClientService pythonAiClientService;

    public DeepfakeService(PythonAiClientService pythonAiClientService) {
        this.pythonAiClientService = pythonAiClientService;
    }

    public DeepfakeResponse analyze(MultipartFile video) {

        try {

            File directory = new File(UPLOAD_DIR);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            String fileName = video.getOriginalFilename();

            File destination = new File(directory, fileName);

            destination.getParentFile().mkdirs();

            video.transferTo(destination);

            return pythonAiClientService.analyzeDeepfake(
                    destination.getAbsolutePath()
            );

        } catch (IOException e) {

            return new DeepfakeResponse(
                    0,
                    "ERROR",
                    e.getMessage()
            );
        }
    }
}