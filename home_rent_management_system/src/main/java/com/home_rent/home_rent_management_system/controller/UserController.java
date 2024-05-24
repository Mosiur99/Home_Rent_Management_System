package com.home_rent.home_rent_management_system.controller;

import com.home_rent.home_rent_management_system.entity.enums.JobType;
import com.home_rent.home_rent_management_system.entity.enums.UserType;
import com.home_rent.home_rent_management_system.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("JobType", JobType.values());
        model.addAttribute("UserType", UserType.values());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam Integer age,
                         @RequestParam String email,
                         @RequestParam JobType jobType,
                         @RequestParam String password,
                         @RequestParam String lastName,
                         @RequestParam String firstName,
                         HttpSession httpSession) {
        userService.signup(age, email, jobType, password, lastName, firstName);
        httpSession.setAttribute("message", "User Register Successfully...");
        return "redirect:/signup";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password) {
        userService.validUser(email, password);
        return "redirect:/user/dashboard";
    }

    @GetMapping("/user/dashboard")
    public String userDashboard() {
        return "dashboard";
    }
}
