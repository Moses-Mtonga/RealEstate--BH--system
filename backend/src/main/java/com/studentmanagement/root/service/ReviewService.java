package com.studentmanagement.root.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.root.entity.Review;

import com.studentmanagement.root.repository.ReviewRepo;


@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepository;

    // Save a new review
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    // Get all reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Get a review by id
    public Review getReviewById(Integer id) {
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isPresent()) {
            return review.get();
        } else {
            return null;
        }
    }

    // Update a review by id
    public Review updateReviewById(Integer id, Review review) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if (optionalReview.isPresent()) {
            Review existingReview = optionalReview.get();
            existingReview.setRating(review.getRating());
            existingReview.setDescription(review.getDescription());
            existingReview.setUser(review.getUser());
            return reviewRepository.save(existingReview);
        } else {
            return null;
        }
    }

    // Delete a review by id
    public String deleteReviewById(Integer id) {
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isPresent()) {
            reviewRepository.deleteById(id);
            return "deleted";
        } else {
            return "delete unsuccessful, object missing";
        }
    }
}
