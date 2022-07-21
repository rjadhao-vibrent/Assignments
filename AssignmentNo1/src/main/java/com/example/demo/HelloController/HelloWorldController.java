package com.example.demo.HelloController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class HelloWorldController {

	
	@GetMapping("/{name}")
	public String HelloWorld(@PathVariable("name") String name ) {
		
		return "Hello " + name + ".";
	}
}
