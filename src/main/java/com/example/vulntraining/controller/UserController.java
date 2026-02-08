package com.example.vulntraining.controller;

import com.example.vulntraining.model.entity.User;
import com.example.vulntraining.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<User> me() {
        // 실제로는 SecurityContext에서 현재 사용자 조회
        return ResponseEntity.ok().build();
    }
}