package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CarDTO;
import com.example.demo.dto.StudentDTO;

@Controller
@RequestMapping("/return")
public class QuizController3 {
	
	@GetMapping("/q1")
	public void quiz3_1() {
	}
	
	@GetMapping("/q2")
	public String quiz3_2() {
		return "/return/test.html";
	}
	
	@ResponseBody
	@GetMapping("/q3")
	public StudentDTO quiz3_3() {
		StudentDTO dto = StudentDTO.builder()
									.no(1)
									.name("둘리")
									.grade(3)
									.build();
		return dto;
	}
	
	@ResponseBody
	@GetMapping("/q4")
	public CarDTO quiz3_4() {
		CarDTO dto = CarDTO.builder()
									.company("현대")
									.model("코나")
									.color("블랙")
									.build();
		return dto;
	}
	
	@ResponseBody
	@GetMapping("/q5")
	public List<StudentDTO> quiz3_5() {
		
		List<StudentDTO> list = new ArrayList<>();
		
		list.add(new StudentDTO(1, "둘리", 3));
		list.add(new StudentDTO(2, "또치", 1));
		list.add(new StudentDTO(3, "도우너", 2));
		
		return list;
	}
	
	@GetMapping("/q6")
	public ResponseEntity<String> quiz3_6() {
		
		return new ResponseEntity<>("response fail", HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@GetMapping("/q7")
	public ResponseEntity<CarDTO> quiz3_7() {
		
		CarDTO dto = CarDTO.builder()
				.company("현대")
				.model("코나")
				.color("블랙")
				.build();
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
		
	}

}
