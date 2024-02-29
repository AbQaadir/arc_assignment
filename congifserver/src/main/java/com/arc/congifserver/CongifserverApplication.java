package com.arc.congifserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CongifserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(CongifserverApplication.class, args);
	}

}
