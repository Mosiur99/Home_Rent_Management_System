package com.home_rent.home_rent_management_system.controller;

import com.home_rent.home_rent_management_system.entity.Admin;
import com.home_rent.home_rent_management_system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminRestController {

    private final AdminService adminService;

    @Autowired
    public AdminRestController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/admin-set")
    public void adminSet(@RequestBody Admin admin) {
        adminService.saveAdmin(admin);
    }
}
