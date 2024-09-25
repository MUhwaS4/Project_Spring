package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	// 메인 화면을 반환하는 메소드
	@GetMapping("/main") // /board/main
	public void main() {
		
	}

}

