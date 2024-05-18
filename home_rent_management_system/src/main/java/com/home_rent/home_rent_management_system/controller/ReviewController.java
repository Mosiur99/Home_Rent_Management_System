package com.home_rent.home_rent_management_system.controller;

import com.home_rent.home_rent_management_system.entity.Review;
import com.home_rent.home_rent_management_system.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/add-review")
    public ResponseEntity<String> addReview(@RequestParam String email,
                                            @RequestParam String comment,
                                            @RequestParam String userName) {
        try {
            reviewService.addReview(email, comment, userName);
        } catch(Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok("Review Added Successfully");
    }

    @PostMapping("/get-reviews")
    public ResponseEntity<List<Review>> getReviews() {
        List<Review> reviews = reviewService.getReviews();
        return ResponseEntity.ok(reviews);
    }
}
