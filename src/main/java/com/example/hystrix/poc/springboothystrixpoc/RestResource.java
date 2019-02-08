package com.example.hystrix.poc.springboothystrixpoc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestResource {
	@GetMapping("/hello")
	public String sayHello() {

		return "HelloWorld";
	}

}
