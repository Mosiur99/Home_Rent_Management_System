package com.home_rent.home_rent_management_system.service.impl;

import com.home_rent.home_rent_management_system.entity.Review;
import com.home_rent.home_rent_management_system.repository.ReviewRepository;
import com.home_rent.home_rent_management_system.service.ReviewService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    @Transactional
    public void addReview(String email, String comment, String userName) {
        Review newReview = new Review();
        newReview.setComment(comment);
        newReview.setEmail(email);
        newReview.setUserName(userName);
        reviewRepository.save(newReview);
    }

    @Override
    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }
}
