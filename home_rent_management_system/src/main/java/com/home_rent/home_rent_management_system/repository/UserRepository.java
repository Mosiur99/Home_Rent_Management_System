package com.home_rent.home_rent_management_system.repository;

import com.home_rent.home_rent_management_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
