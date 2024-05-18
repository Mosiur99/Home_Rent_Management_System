package com.home_rent.home_rent_management_system.repository;

import com.home_rent.home_rent_management_system.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    Optional<User> findUserByEmail(String email);

    @Query(value = "SELECT user FROM User user WHERE user.email = :email")
    User duplicateEmailCheck(@Param("email") String email);
}
