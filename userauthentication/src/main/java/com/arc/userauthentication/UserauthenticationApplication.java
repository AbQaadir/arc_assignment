package com.arc.userauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class UserauthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserauthenticationApplication.class, args);
	}

}
