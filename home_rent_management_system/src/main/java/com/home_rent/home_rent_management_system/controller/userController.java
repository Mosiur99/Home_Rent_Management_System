package com.home_rent.home_rent_management_system.controller;

import com.home_rent.home_rent_management_system.entity.User;
import com.home_rent.home_rent_management_system.entity.enums.Division;
import com.home_rent.home_rent_management_system.entity.enums.JobType;
import com.home_rent.home_rent_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class userController {

    private final UserService userService;

    @Autowired
    public userController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("JobType", JobType.values());
        model.addAttribute("Division", Division.values());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        userService.signup(user);
        return "redirect:/signup";
    }
}
