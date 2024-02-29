package com.arc.propertyms.property.client;


import com.arc.propertyms.property.external.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Component
@FeignClient(name = "REVIEW-SERVICE")
public interface ReviewClient {
    @GetMapping("/review")
    List<Review> getAllReviews(@RequestParam("adminId") Long adminId);
}
