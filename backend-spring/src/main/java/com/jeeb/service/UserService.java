package com.jeeb.service;

import com.jeeb.dto.request.UpdateEmailRequest;
import com.jeeb.dto.request.UpdatePasswordRequest;
import com.jeeb.dto.response.UserResponse;
import com.jeeb.entity.User;
import com.jeeb.exception.BadRequestException;
import com.jeeb.exception.NotFoundException;
import com.jeeb.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("User not found"));
        return toResponse(user);
    }

    public UserResponse updateEmail(Long id, UpdateEmailRequest request) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("User not found"));
        if (!passwordEncoder.matches(request.password(), user.getPasswordHash())) {
            throw new BadRequestException("Invalid password");
        }
        user.setEmail(request.email());
        return toResponse(userRepository.save(user));
    }

    public UserResponse updatePassword(Long id, UpdatePasswordRequest request) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("User not found"));
        if (!passwordEncoder.matches(request.oldPassword(), user.getPasswordHash())) {
            throw new BadRequestException("Invalid password");
        }
        user.setPasswordHash(passwordEncoder.encode(request.newPassword()));
        return toResponse(userRepository.save(user));
    }

    private UserResponse toResponse(User user) {
        return new UserResponse(user.getId(), user.getEmail(), user.getStatus(), user.getCreatedAt());
    }
}
