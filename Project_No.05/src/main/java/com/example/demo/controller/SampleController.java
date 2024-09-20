package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.SampleDTO;



@Controller
@RequestMapping("/sample")
public class SampleController {
	
	@GetMapping("/ex1") // /sample/ex1
	public void ex1() {
		
		// 리턴 타입이 void인 경우, url 경로와 일치하는 html 파일을 찾아 반환
		// 템플릿 경로: /templates/sample/ex1.html
		
	}
	
	// Model은 화면에 값을 전달하는 객체
	@GetMapping("/ex2") // /sample/ex2
	public void ex2(Model model) {
		
		
		// 화면에 전달하고 싶은 데이터 담기 (변수명, 값)
		model.addAttribute("mas", "안녕하세요");
		
	}
	
	@GetMapping("/ex3")
	public void ex3(Model model) {
		
		model.addAttribute("msg1", "안녕하세요");
		model.addAttribute("msg2", "반가워요");
		// 모델 객체에 데이터를 여러 번 담을 수 있다
		
	}
	
	@GetMapping("/ex4")
	public void ex4(Model model) {
		
		SampleDTO dto = new SampleDTO(1, "hello", LocalDate.now()); // 날짜: 현재 날짜 입력
		model.addAttribute("dto", dto); // 화면에 객체 전달
		
	}
	
	@GetMapping("/ex5")
	public void ex5(Model model) {
		
		List<SampleDTO> list = new ArrayList<>();
		
		list.add(new SampleDTO(1, "aaa", LocalDate.now()));
		list.add(new SampleDTO(2, "bbb", LocalDate.now()));
		list.add(new SampleDTO(3, "bbb", LocalDate.now()));
		
		model.addAttribute("list", list); // 화면에 리스트 전달
		
	}
	
	
}
