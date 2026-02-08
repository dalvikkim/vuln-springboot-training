package com.example.vulntraining.service;

import com.example.vulntraining.model.entity.User;
import com.example.vulntraining.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    // UserService.java 에 추가
    public List<User> findAll() {
        return userRepository.findAll();
    }    
}