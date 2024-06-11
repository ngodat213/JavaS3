package com.hutech.javas3d3.Controllers;

import com.hutech.javas3d3.Entities.User;
import com.hutech.javas3d3.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.GeneralSecurityException;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterPage() {
        return "User/register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, Model model) {
        try {
            User registeredUser = userService.registerUser(username, password);
            model.addAttribute("message", "Registration successful");
            return "User/login"; // Redirect to login page after successful registration
        } catch (GeneralSecurityException e) {
            model.addAttribute("message", "Registration failed: " + e.getMessage());
            return "User/register";
        }
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "User/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        try {
            User user = userService.loginUser(username, password);
            if (user != null) {
                model.addAttribute("message", "Login successful");
                return "index"; // Redirect to a welcome page or dashboard after successful login
            } else {
                model.addAttribute("message", "Invalid username or password");
                return "User/login";
            }
        } catch (GeneralSecurityException e) {
            model.addAttribute("message", "Login failed: " + e.getMessage());
            return "User/login";
        }
    }
}
