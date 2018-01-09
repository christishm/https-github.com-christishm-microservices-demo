package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoPriceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoPriceClientApplication.class, args);
	}
}
