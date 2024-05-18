package com.home_rent.home_rent_management_system.service;

import com.home_rent.home_rent_management_system.entity.Review;

import java.util.List;

public interface ReviewService {

    void addReview(String email, String comment, String userName);

    List<Review> getReviews();
}
