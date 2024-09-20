package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	@GetMapping("/q1") // /quiz/q1
	public void quiz1(Model model) {
		
		model.addAttribute("name", "둘리");
		model.addAttribute("age", 20);
		model.addAttribute("address", "인천 구월동");
		
	}
	
	@GetMapping("/q2") // /quiz/q1
	public void quiz2(Model model) {
		
		model.addAttribute("title", "스프링부트웹프로젝트");
		model.addAttribute("wirter", "구멍가게 코딩단");
		model.addAttribute("date", LocalDate.of(2022, 12, 25));
		
	}

}
