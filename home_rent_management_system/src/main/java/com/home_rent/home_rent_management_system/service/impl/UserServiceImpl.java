package com.home_rent.home_rent_management_system.service.impl;

import com.home_rent.home_rent_management_system.entity.User;
import com.home_rent.home_rent_management_system.entity.enums.Division;
import com.home_rent.home_rent_management_system.entity.enums.JobType;
import com.home_rent.home_rent_management_system.exception.ResourceNotFoundExceptionHandler;
import com.home_rent.home_rent_management_system.repository.UserRepository;
import com.home_rent.home_rent_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signup(Integer age,
                       String email,
                       JobType jobType,
                       String password,
                       String lastName,
                       String firstName,
                       Division division) {
        if(Objects.nonNull(userRepository.duplicateEmailCheck(email))){
            throw new ResourceNotFoundExceptionHandler("this email was already registered");
        }

        User user = new User();
        user.setAge(age);
        user.setEmail(email);
        user.setJobType(jobType);
        user.setPassword(password);
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setDivision(division);
        userRepository.save(user);
    }
}
