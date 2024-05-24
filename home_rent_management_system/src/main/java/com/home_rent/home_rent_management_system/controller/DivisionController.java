package com.home_rent.home_rent_management_system.controller;

import com.home_rent.home_rent_management_system.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DivisionController {

    private final DivisionService divisionService;

    @Autowired
    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @GetMapping("/admin/division-added")
    public String divisionAdded() {
        return "divisionAdded";
    }

    @PostMapping("/admin/division-added")
    public String divisionAdded(@RequestParam String divisionName) {
        divisionService.divisionAdded(divisionName);
        return "divisionAdded";
    }
}
