package com.arc.propertyms.property.client;

import com.arc.propertyms.property.external.Admin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "AUTHENTICATION-SERVICE")
public interface AdminClient {

    @GetMapping("/admin/{id}")
    Admin getAdminById(@PathVariable("id") Long id);
}
