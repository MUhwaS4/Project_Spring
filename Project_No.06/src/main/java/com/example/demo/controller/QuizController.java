package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/method/q")
@Controller
public class QuizController {
	
	@ResponseBody
	@GetMapping
	public String quiz1_1() {
		
		System.out.println("get 방식!");
		return "get test";
		
	}
	
	@ResponseBody
	@PostMapping
	public String quiz1_2() {
		
		System.out.println("post 방식!");
		return "post test";
		
	}
	
	@ResponseBody
	@PutMapping
	public String quiz1_3() {
		
		System.out.println("put 방식!");
		return "put test";
		
	}
	
	@ResponseBody
	@DeleteMapping
	public String quiz1_4() {
		
		System.out.println("delete 방식!");
		return "delete test";
		
	}

}
