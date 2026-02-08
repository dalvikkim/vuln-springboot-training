package com.example.vulntraining.controller;

import com.example.vulntraining.model.entity.User;
import com.example.vulntraining.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A03:2021 Injection (SQL Injection)
 * - 사용자 입력을 쿼리에 문자열 결합 (절대 실제 서비스에서 사용 금지)
 */
@RestController
@RequestMapping("/api/injection")
@RequiredArgsConstructor
public class InjectionController {

    private final UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    // 취약: 로그인 이름을 그대로 SQL에 결합
    @GetMapping("/user")
    public List<User> findUserByName(@RequestParam String name) {
        String jpql = "SELECT u FROM User u WHERE u.username = '" + name + "'";
        return entityManager.createQuery(jpql, User.class).getResultList();
    }

    // 예: name = ' OR '1'='1  등으로 전체 조회 가능
}