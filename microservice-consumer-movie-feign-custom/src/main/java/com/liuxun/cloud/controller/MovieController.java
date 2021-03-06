package com.liuxun.cloud.controller;

import com.liuxun.cloud.FeignClient2;
import com.liuxun.cloud.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.liuxun.cloud.entity.User;

@RestController
public class MovieController {

	@Autowired
	private UserFeignClient userFeignClient;

	@Autowired
	private FeignClient2 feignClient2;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		return userFeignClient.findById(id);
	}

	@GetMapping("/{serviceName}")
	public String findServiceInfoFromEurekaByServiceName(@PathVariable String serviceName){
		return feignClient2.findServiceInfoFromEurekaByServiceName(serviceName);
	}


}
