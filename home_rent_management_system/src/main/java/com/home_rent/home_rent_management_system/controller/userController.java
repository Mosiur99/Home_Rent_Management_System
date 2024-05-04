package com.home_rent.home_rent_management_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class userController {

    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
