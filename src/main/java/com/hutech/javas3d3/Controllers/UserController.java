package com.hutech.javas3d3.Controllers;

import com.hutech.javas3d3.Entities.User;
import com.hutech.javas3d3.RequestEntities.StudentCreate;
import com.hutech.javas3d3.Services.ObservableService;
import com.hutech.javas3d3.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("loggedInUser")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ObservableService observableService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new StudentCreate());
        return "User/register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute StudentCreate req) {
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(req.getPassword()); // Password hashing happens in the setPasswordHash method
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "User/login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute User user, Model model) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            observableService.saveLoginTime(existingUser);
            model.addAttribute("loggedInUser", existingUser);
            return "redirect:/home";
        } else {
            return "redirect:/login?error";
        }
    }

    @GetMapping("/home")
    public String home() {
        return "Home/index";
    }

    @GetMapping("/logout")
    public String logout(@SessionAttribute("loggedInUser") User user, SessionStatus sessionStatus) {
        observableService.saveLogoutTime(user);
        sessionStatus.setComplete();
        return "redirect:/login";
    }
}