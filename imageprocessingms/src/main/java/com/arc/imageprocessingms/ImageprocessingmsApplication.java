package com.arc.imageprocessingms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ImageprocessingmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageprocessingmsApplication.class, args);
	}

}
