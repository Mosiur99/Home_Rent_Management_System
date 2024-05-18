package com.home_rent.home_rent_management_system.service.impl;

import com.home_rent.home_rent_management_system.entity.User;
import com.home_rent.home_rent_management_system.entity.enums.Role;
import com.home_rent.home_rent_management_system.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByEmail(email);
        if(user.isEmpty()) {
            throw new UsernameNotFoundException(email);
        }

        User userObj = user.get();
        return org.springframework.security.core.userdetails.User.builder()
                .username(userObj.getEmail())
                .password(userObj.getPassword())
                .roles(userObj.getRole().name())
                .build();
    }
}
