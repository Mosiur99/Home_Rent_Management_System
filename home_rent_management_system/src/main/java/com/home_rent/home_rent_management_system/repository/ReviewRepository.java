package com.home_rent.home_rent_management_system.repository;

import com.home_rent.home_rent_management_system.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
