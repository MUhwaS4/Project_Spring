package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.personDTO;

@Controller
@RequestMapping("/quiz") // 상위 폴더 (=중간경로)
public class QuizController {
	
	// model: 뷰에 데이터를 전달하는 객체
	// void: URL 경로에 따라 HTML 파일 반환
	@GetMapping("/q1") // /quiz/q1 // 겟매핑("연결파일명")
	public void quiz1(Model model) {
		
		model.addAttribute("name", "둘리");
		model.addAttribute("age", 20);
		model.addAttribute("address", "인천 구월동");
		
	}
	
	@GetMapping("/q2") // /quiz/q2
	public void quiz2(Model model) {
		
		// 기초타입의 경우 바로 내용을 작성해도 되는데
		// 참조타입의 경우 따로 객체를 생성해야 함
		
		model.addAttribute("title", "스프링부트웹프로젝트");
		model.addAttribute("wirter", "구멍가게 코딩단");
		model.addAttribute("date", LocalDate.of(2022, 12, 25));
		
	}
	
	@GetMapping("/q3") // /quiz/q3
	public void quiz3(Model model) {
		
		personDTO dto = new personDTO("둘리", 20, "인천 구월동");
		model.addAttribute("dto", dto);
		
	}
	
	@GetMapping("/q4") // /quiz/q4
	public void quiz4(Model model) {
		
		BookDTO dto = new BookDTO("스프링부트웹프로젝트", "구멍가게코딩단", LocalDate.of(2022, 12, 25));
		model.addAttribute("dto", dto);
		
	}
	
	@GetMapping("/q5") // /quiz/q5
	public void quiz5(Model model) {
		
		int[] num = {1,2,3,4,5,6,7,8,9,10};
		
		model.addAttribute("arr", num);
		
	}
	
	@GetMapping({"/q6", "/q7"}) // /quiz/q6
	public void quiz6(Model model) {
		
		List<personDTO> list = new ArrayList<>();
		
		list.add(new personDTO("둘리", 20, "인천 구월동"));
		list.add(new personDTO("또치", 30, "서울 신림동"));
		list.add(new personDTO("도우너", 40, "부산 문래동"));
		
		model.addAttribute("list", list);
		
	}
	
	@GetMapping({"/q8", "/q9"}) // /quiz/q8
	public void quiz8(Model model) {
		
		List<personDTO> list = new ArrayList<>();
		
		list.add(new personDTO("박하나", 25, "인천 구월동"));
		list.add(new personDTO("홍재범", 17, "서울 신림동"));
        list.add(new personDTO("문유리", 31, "부산 문래동"));
        list.add(new personDTO("김재민", 8, "인천 연수동"));
        list.add(new personDTO("장유라", 33, "부산 문래동"));
		
		model.addAttribute("list", list);
		
	}

}
