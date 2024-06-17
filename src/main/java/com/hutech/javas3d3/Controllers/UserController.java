package com.hutech.javas3d3.Controllers;

import com.hutech.javas3d3.Entities.User;
import com.hutech.javas3d3.RequestEntities.StudentCreate;
import com.hutech.javas3d3.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new StudentCreate());
        return "User/register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute StudentCreate req) {
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(req.getPassword());
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "User/login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute User user) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return "redirect:/home";
        } else {
            return "redirect:/login?error";
        }
    }

    @GetMapping("/home")
    public String home() {
        return "index";
    }
}
