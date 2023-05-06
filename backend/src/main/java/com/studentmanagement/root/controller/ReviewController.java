package com.studentmanagement.root.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.studentmanagement.root.entity.Review;
import com.studentmanagement.root.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Create a new review
    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review savedReview = reviewService.saveReview(review);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    // Get all reviews
    @GetMapping("/all")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // Get a review by id
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Integer id) {
        Review review = reviewService.getReviewById(id);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    // Update a review by id
    @PutMapping("update/{id}")
    public ResponseEntity<Review> updateReviewById(@PathVariable Integer id, @RequestBody Review review) {
        Review updatedReview = reviewService.updateReviewById(id, review);
        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }

    // Delete a review by id
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Integer id) {
        String deleteMessage = reviewService.deleteReviewById(id);
        return new ResponseEntity<>(deleteMessage, HttpStatus.OK);
    }
}
