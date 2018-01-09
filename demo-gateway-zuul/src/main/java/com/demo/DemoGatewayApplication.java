package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


/**
This class configures Gateway API for all the microservices to communicate and collaborate.
DesignPattern Used: Facade pattern which provides an unified interface for all microservices providing security,caching, routing capabilities.
*/
@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients
public class DemoGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGatewayApplication.class, args);
	}
}
