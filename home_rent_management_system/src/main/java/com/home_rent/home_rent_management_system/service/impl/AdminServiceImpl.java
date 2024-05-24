package com.home_rent.home_rent_management_system.service.impl;

import com.home_rent.home_rent_management_system.entity.Admin;
import com.home_rent.home_rent_management_system.repository.AdminRepository;
import com.home_rent.home_rent_management_system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
    }
}
