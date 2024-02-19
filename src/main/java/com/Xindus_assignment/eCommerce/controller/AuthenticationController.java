package com.Xindus_assignment.eCommerce.controller;

import com.Xindus_assignment.eCommerce.model.User;
import com.Xindus_assignment.eCommerce.security.SecurityConfig;
import com.Xindus_assignment.eCommerce.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final WishlistService wishlistService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationController(WishlistService wishlistService, PasswordEncoder passwordEncoder) {
        this.wishlistService = wishlistService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody User user) {
        // Check if the username is already taken
        if (wishlistService.isUserExists(user.getUsername())) {
            return "Username already exists. Choose a different username.";
        }

        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user to the database
        wishlistService.saveUser(user);

        return "User registered successfully!";
    }

    @GetMapping("/login")
    public String login() {
        // Get the currently authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return "Logged in as: " + username;
    }
}
