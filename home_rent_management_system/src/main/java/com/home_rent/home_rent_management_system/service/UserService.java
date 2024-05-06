package com.home_rent.home_rent_management_system.service;

import com.home_rent.home_rent_management_system.entity.enums.Division;
import com.home_rent.home_rent_management_system.entity.enums.JobType;

public interface UserService {

    void signup(Integer age,
                String email,
                JobType jobType,
                String password,
                String lastName,
                String firstName,
                Division division);
}
