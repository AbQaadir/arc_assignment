package com.arc.reviewms.review;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@AllArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long adminId) {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @PostMapping
    public ResponseEntity<String> createReview(@RequestParam Long adminId ,@RequestBody Review review) {
        boolean isReviewSaved = reviewService.createReview(adminId, review);
        if (isReviewSaved) {
            return ResponseEntity.ok("Review created successfully");
        }
        return ResponseEntity.badRequest().body("Review not saved");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReview(@PathVariable Long id) {
        Review review = reviewService.getReviewById(id);
        if (review != null) {
            return ResponseEntity.ok(review);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateReview(@PathVariable Long id, @RequestBody Review review) {
        boolean isReviewUpdated = reviewService.updateReview(id, review);
        if (isReviewUpdated) {
            return ResponseEntity.ok("Review updated successfully");
        }
        return ResponseEntity.badRequest().body("Review not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id) {
        boolean isReviewDeleted = reviewService.deleteReview(id);
        if (isReviewDeleted) {
            return ResponseEntity.ok("Review deleted successfully");
        }
        return ResponseEntity.badRequest().body("Review not found");
    }

}
