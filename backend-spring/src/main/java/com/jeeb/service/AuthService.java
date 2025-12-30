package com.jeeb.service;

import com.jeeb.dto.request.LoginRequest;
import com.jeeb.dto.request.RegisterRequest;
import com.jeeb.dto.response.AuthResponse;
import com.jeeb.dto.response.UserResponse;
import com.jeeb.entity.User;
import com.jeeb.exception.BadRequestException;
import com.jeeb.repository.UserRepository;
import java.time.Instant;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email())
            .orElseThrow(() -> new BadRequestException("Invalid credentials"));

        if (!passwordEncoder.matches(request.password(), user.getPasswordHash())) {
            throw new BadRequestException("Invalid credentials");
        }

        return new AuthResponse(toResponse(user), "Login موفق");
    }

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new BadRequestException("Email already exists");
        }

        User user = new User(
            request.email(),
            passwordEncoder.encode(request.password()),
            "active",
            Instant.now()
        );
        User saved = userRepository.save(user);
        return new AuthResponse(toResponse(saved), "Registration موفق");
    }

    private UserResponse toResponse(User user) {
        return new UserResponse(user.getId(), user.getEmail(), user.getStatus(), user.getCreatedAt());
    }
}
