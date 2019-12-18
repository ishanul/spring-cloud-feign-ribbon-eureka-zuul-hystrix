package com.ishan.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitsConfig retrieveLimitsConfig(){
		return new LimitsConfig(configuration.getMaximum(), configuration.getMinimum());
	}
	
	@GetMapping("/limits/hystrix")
	@HystrixCommand(fallbackMethod="fallBackMethod")
	public LimitsConfig retrieveLimitsConfigHystrix(){
		//return new LimitsConfig(configuration.getMaximum(), configuration.getMinimum());
		throw new RuntimeException("error");
	}
	
	public LimitsConfig fallBackMethod(){
		return new LimitsConfig(1000, 1);
	}
}
