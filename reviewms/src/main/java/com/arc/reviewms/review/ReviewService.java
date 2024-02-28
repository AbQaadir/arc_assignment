package com.arc.reviewms.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews();

    boolean createReview(Long adminId, Review review);

    boolean deleteReview(Long reviewId);

    Review getReviewById(Long review);

    boolean updateReview(Long reviewId, Review updatedReview);

}
