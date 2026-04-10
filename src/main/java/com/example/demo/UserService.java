package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String register(RegisterRequest request) {
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());

        if (existingUser.isPresent()) {
            return "User with this email already exists";
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userRepository.save(user);

        return "User registered successfully";
    }

    public String login(LoginRequest request) {
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());

        if (existingUser.isEmpty()) {
            return "User not found";
        }

        User user = existingUser.get();

        if (!user.getPassword().equals(request.getPassword())) {
            return "Wrong password";
        }

        return "Login successful";
    }
}