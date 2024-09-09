package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/hello") // http://localhost:8080/hello에서 :8080 뒤 문자
	public String hello() {
		return "안녕하세요";
	}

}
