package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        String result = userService.register(request);
        return new AuthResponse(result);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        String result = userService.login(request);
        return new AuthResponse(result);
    }
}