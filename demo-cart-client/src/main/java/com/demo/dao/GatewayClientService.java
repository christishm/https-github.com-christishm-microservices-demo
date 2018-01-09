package com.demo.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("DEMO-GATEWAY-ZUUL")
public interface GatewayClientService {
    
	@RequestMapping(value="/get-logged-user",method=RequestMethod.GET)
	String getLoggedInUserName();
}
