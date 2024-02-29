package com.arc.propertyms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PropertymsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertymsApplication.class, args);
    }

}
