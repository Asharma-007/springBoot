package com.example.hystrix.poc.springboothystrixpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication(scanBasePackages={
		"com.example.hystrix.poc.*"})
public class SpringBootHystrixPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHystrixPocApplication.class, args);
	}

}
