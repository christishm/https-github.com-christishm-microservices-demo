package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicroServicesServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesServerApplication.class, args);
	}
}
