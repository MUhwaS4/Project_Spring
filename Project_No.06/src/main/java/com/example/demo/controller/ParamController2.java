package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.BookDTO;

@Controller
@RequestMapping("/param2")
public class ParamController2 {
	
	// 사용자가 전달한 파라미터 처리하기
	
	// GET /param2/ex1?i=100 (주소명?key_파라미터=value)
	@ResponseBody
	@GetMapping("/ex1")
	public String ex1(@RequestParam(name = "i") int i) {
		
		System.out.println("int형 파라미터 수집: " + i);
		
		return "ok";
		
		// 이 경우 주소를 작성할 때 파라미터도 함께 작성해야 함
		
	}
	
	// GET /param2/ex2?i=100&c=a (주소명?key1=value&key2=value)
	@ResponseBody
	@GetMapping("/ex2")
	public String ex2(	@RequestParam(name = "i") int i,
						@RequestParam(name = "c") char c) {
		
		System.out.println("int형 파라미터 수집: " + i);
		System.out.println("char형 파라미터 수집: " + c);
		
		return "ok";
		
	}
	
	// GET /param2/ex3?arr=1&arr=2&arr=3 (주소명?key1=value&key2=value)
	// arr라는 이름으로 파라미터를 여러 개 전달할 수 있음
	// ex_ ?arr=1&arr=2&arr=3
	@ResponseBody
	@GetMapping("/ex3")
	public String ex3(@RequestParam(name = "arr") int[] arr) {
		
		System.out.println("int형 배열 수집: " + Arrays.toString(arr)); // 배열 -> 문자열 변환
		
		return "ok";
		
	}
	
	// GET /param2/ex4?list=1&list=2&list=3 (주소명?key1=value&key2=value)
	@ResponseBody
	@GetMapping("/ex4")
	public String ex4(@RequestParam(name = "list") ArrayList<Integer> list) {
		
		System.out.println("int형 리스트 수집: " + list);
		
		return "ok";
		
	}
	
	// GET /param2/ex5?date=2024-09-24
	@ResponseBody
	@GetMapping("/ex5")
	// ?date=2024-09-24
	// 기본값: "yyyy-MM-dd"
	// 그 외: "yyyy/MM/dd" of "yyyyMMdd"
	public String ex5(@RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy/MM/dd") LocalDate date) {
		
		System.out.println("날짜 데이터 수집: " + date);
		
		return "ok";
		
	}
	
	@ResponseBody
	@GetMapping("/ex6/{i}")
	// ex_ /param2/ex6/100
	public String ex6(@PathVariable(name = "i") int i) {
		
		System.out.println("int형 파라미터 수집: " + i);
		
		return "ok";
		
	}
	
	// @RequestParam과 @PathVariable의 차이점
	
		// @RequestParam:
			// 주소창에 쿼리 파라미터로 key=value 형태로 들어감 (예: ?key=value).
			// String, int처럼 단순한 타입에서 주로 사용
			// 주로 특정 데이터를 key와 value 쌍으로 호출할 때 사용함.
			// 예시: /board?category=1
		
		// @PathVariable:
			// 주소 경로의 일부로 값을 전달받음 (예: /board/{id}).
			// 주로 객체에서 사용
			// 경로의 일부로 데이터를 호출하며, 주소에 직접 포함됨.
			// 예시: /board/1 (여기서 1이 PathVariable 값)
	
	
	@ResponseBody
	@GetMapping("/ex7")
	// @ModelAttribute 생략 가능
	// ex_ ?title=자바프로그래밍&publisher=한빛컴퍼니&price=10000
	public String ex7(@ModelAttribute BookDTO dto) {
		
		System.out.println("객체 파라미터 수집: " + dto);
		
		return "ok";
		
	}
	

}
