package com.example.vulntraining.controller;

import com.example.vulntraining.model.entity.Document;
import com.example.vulntraining.model.entity.User;
import com.example.vulntraining.repository.DocumentRepository;
import com.example.vulntraining.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A01:2021 Broken Access Control
 * - IDOR: document id만 알면 누구나 조회 가능
 * - Admin API에 역할 검사 없음
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccessControlController {

    private final DocumentRepository documentRepository;
    private final UserService userService;

    // IDOR: 소유자 검증 없이 문서 조회
    @GetMapping("/documents/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable Long id) {
        return documentRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Admin 전용인데 권한 체크 없음
    @GetMapping("/admin/users")
    public List<User> listAllUsers() {
        return userService.findAll();
    }

    // 다른 사용자 프로필을 id만으로 조회 가능
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserProfile(@PathVariable Long id) {
        return userService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}