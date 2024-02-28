package com.arc.reviewms.review.impl;

import com.arc.reviewms.review.Review;
import com.arc.reviewms.review.ReviewRepository;
import com.arc.reviewms.review.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public boolean createReview(Long adminId, Review review) {
        review.setAdminId(adminId);
        reviewRepository.save(review);
        return true;
    }

    @Override
    public boolean deleteReview(Long reviewId) {
        try {
            reviewRepository.deleteById(reviewId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Review getReviewById(Long reviewId) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
        return optionalReview.orElse(null);
    }

    @Override
    public boolean updateReview(Long reviewId, Review updatedReview) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
        if (optionalReview.isPresent()) {

            Review review = optionalReview.get();

            review.setTitle(updatedReview.getTitle());
            review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            review.setAdminId(updatedReview.getAdminId());

            reviewRepository.save(review);

            return true;
        }
        return false;
    }
}
