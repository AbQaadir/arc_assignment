package com.arc.reviewms.review.messaging;


import com.arc.reviewms.review.Review;
import com.arc.reviewms.review.dto.ReviewMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;


@Service
public class ReviewMessageProducer {

    private final RabbitTemplate rabbitTemplate;

    public ReviewMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(Review review) {

        ReviewMessage reviewMessage = new ReviewMessage();

        reviewMessage.setId(review.getId());
        reviewMessage.setTitle(review.getTitle());
        reviewMessage.setDescription(review.getDescription());
        reviewMessage.setRating(review.getRating());
        reviewMessage.setAdminId(review.getAdminId());

        rabbitTemplate.convertAndSend("adminRattingsQueue", reviewMessage);
    }

}
