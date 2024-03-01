package com.arc.propertyms.property.messaging;

import com.arc.propertyms.property.dto.ReviewMessage;
import com.arc.propertyms.property.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class ReviewMessageConsumer {

    private final PropertyService propertyService;

    @RabbitListener(queues = "adminRattingsQueue")
    public void receiveReview(ReviewMessage reviewMessage) {
        propertyService.updatePropertyRating(reviewMessage);
    }


}
