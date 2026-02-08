package com.example.vulntraining.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * A10:2021 SSRF
 * - 사용자 입력 URL로 요청을 보냄 (내부 IP, 메타데이터 등 접근 가능)
 */
@RestController
@RequestMapping("/api/ssrf")
public class SsrfController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/fetch")
    public ResponseEntity<String> fetchUrl(@RequestParam String url) {
        try {
            String body = restTemplate.getForObject(URI.create(url), String.class);
            return ResponseEntity.ok(body != null ? body : "");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}