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
	
	// 커스텀 로그인 화면을 반환하는 메소드
	// 해당 메소드를 통하지 않으면 시큐리티에서 제공하는 템플릿을 자동으로 사용하게 됨
	@GetMapping("/customlogin")
	public String login() {
		return "/home/login";
	}

}