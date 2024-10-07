package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	// 메인 화면을 반환하는 메소드
	@GetMapping("/") // localhost:8080/
	public String home() {
		// 반환할 뷰의 경로를 직접 작성
		return "/home/main";
	}

}