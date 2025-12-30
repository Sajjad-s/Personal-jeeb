package com.jeeb.controller;

import com.jeeb.dto.request.UpdateEmailRequest;
import com.jeeb.dto.request.UpdatePasswordRequest;
import com.jeeb.dto.response.UserResponse;
import com.jeeb.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}/email")
    public UserResponse updateEmail(@PathVariable Long id, @Valid @RequestBody UpdateEmailRequest request) {
        return userService.updateEmail(id, request);
    }

    @PutMapping("/{id}/password")
    public UserResponse updatePassword(@PathVariable Long id, @Valid @RequestBody UpdatePasswordRequest request) {
        return userService.updatePassword(id, request);
    }
}
