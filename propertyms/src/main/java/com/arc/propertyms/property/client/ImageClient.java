package com.arc.propertyms.property.client;

import com.arc.propertyms.property.external.Image;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "IMAGE-PROCESSING-SERVICE")
public interface ImageClient {
    @GetMapping("/images/{id}")
    Image downloadImageById(@PathVariable("id") Long id);
}
