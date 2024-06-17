package com.hutech.javas3d3.Controllers;

import com.hutech.javas3d3.Entities.Observable;
import com.hutech.javas3d3.Entities.User;
import com.hutech.javas3d3.Repositories.ObservableRepository;
import com.hutech.javas3d3.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/observable")
public class ObservableController {

    @Autowired
    private ObservableRepository observableRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/home")
    public String home(User user) {
        Observable observable = new Observable();
        observable.setUser(user);
        observable.setTimeIn(LocalDateTime.now());
        observableRepository.save(observable);
        return "home";
    }

    @GetMapping("/logout")
    public String logout(User user) {
        return "redirect:/login";
    }
}
