package com.yuvaraj.liveguard.service;

import java.io.File;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.yuvaraj.liveguard.dto.ContextResponse;
import com.yuvaraj.liveguard.dto.DeepfakeResponse;
import com.yuvaraj.liveguard.dto.PythonAiResponse;
import com.yuvaraj.liveguard.dto.PythonContextResponse;
import com.yuvaraj.liveguard.dto.PythonSyntheticResponse;
import com.yuvaraj.liveguard.dto.SyntheticResponse;

@Service
public class PythonAiClientService {

    private final RestTemplate restTemplate = new RestTemplate();

    public DeepfakeResponse analyzeDeepfake(String filePath) {

        try {

            File file = new File(filePath);

            MultiValueMap<String, Object> body =
                    new LinkedMultiValueMap<>();

            body.add(
                    "video",
                    new FileSystemResource(file)
            );

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(
                    MediaType.MULTIPART_FORM_DATA
            );

            HttpEntity<MultiValueMap<String, Object>> request =
                    new HttpEntity<>(body, headers);

            PythonAiResponse response =
                    restTemplate.postForObject(
                            "http://localhost:8000/analyze/deepfake",
                            request,
                            PythonAiResponse.class
                    );

            return new DeepfakeResponse(
                    response.getRiskScore(),
                    response.getRiskLevel(),
                    response.getSummary()
            );

        } catch (Exception e) {

            return new DeepfakeResponse(
                    0,
                    "ERROR",
                    e.getMessage()
            );
        }
    }

    public ContextResponse analyzeContext(
            String filePath,
            String claim
    ) {

        try {

            File file = new File(filePath);

            MultiValueMap<String, Object> body =
                    new LinkedMultiValueMap<>();

            body.add(
                    "video",
                    new FileSystemResource(file)
            );

            body.add(
                    "claim",
                    claim
            );

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(
                    MediaType.MULTIPART_FORM_DATA
            );

            HttpEntity<MultiValueMap<String, Object>> request =
                    new HttpEntity<>(body, headers);

            PythonContextResponse response =
                    restTemplate.postForObject(
                            "http://localhost:8000/analyze/context",
                            request,
                            PythonContextResponse.class
                    );

            return new ContextResponse(
                    response.getRiskScore(),
                    response.getRiskLevel(),
                    response.getSummary()
            );

        } catch (Exception e) {

            return new ContextResponse(
                    0,
                    "ERROR",
                    e.getMessage()
            );
        }
    }

    public SyntheticResponse analyzeSynthetic(
            String filePath
    ) {

        try {

            File file = new File(filePath);

            MultiValueMap<String, Object> body =
                    new LinkedMultiValueMap<>();

            body.add(
                    "video",
                    new FileSystemResource(file)
            );

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(
                    MediaType.MULTIPART_FORM_DATA
            );

            HttpEntity<MultiValueMap<String, Object>> request =
                    new HttpEntity<>(body, headers);

            PythonSyntheticResponse response =
                    restTemplate.postForObject(
                            "http://localhost:8000/analyze/synthetic",
                            request,
                            PythonSyntheticResponse.class
                    );

            return new SyntheticResponse(
                    response.getRiskScore(),
                    response.getRiskLevel(),
                    response.getSummary()
            );

        } catch (Exception e) {

            return new SyntheticResponse(
                    0,
                    "ERROR",
                    e.getMessage()
            );
        }
    }
}