package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CarDTO;
import com.example.demo.dto.StudentDTO;

@Controller
@RequestMapping("/param") // 메소드 중간경로
@ResponseBody // 모든 메소드가 JSON 형식으로 응답 반환
// 전체 중복된다면 클래스 레벨로 올려도 됨
public class QuizController2 {
	
	// 1, 2, 3QJS: 간단한 파라미터는 URL에 데이터를 담을 것
	// 간단 -> @RequestParam 또는 @PathVariable
	
	// GET 요청 + Q1 주소 연결, URL에서 전달된 문자열 파라미터 수집
	
	@GetMapping("/q1")
	public String quiz2_1(@RequestParam(name = "text") String text) {	
		
		System.out.println("String 타입 파라미터 수집: " + text);
		
		return "Quiz 1 ok";
		
		// localhost:8080/param/q1?text=hello
		
	}
	
	// GET 요청 + Q2 주소 연결, URL에서 전달된 실수형, 논리형 파라미터 수집
	@GetMapping("/q2")
	public String quiz2_2(	@RequestParam(name = "num") float num,
							@RequestParam(name = "test") boolean test) {		
				
		System.out.println("float 타입 파라미터 수집: " + num + ", boolean 타입 파라미터 수집: " + test);
		
		return "Quiz 2 ok";
		
		// localhost:8080/param/q2?num=1.55&test=true
		
	}
	
	// GET 요청 + Q3 주소 연결, URL에서 문자형 배열 파라미터 수집
	@GetMapping("/q3")
	public String quiz2_3(@RequestParam(name = "list") char[] list) {		
				
		System.out.println("char형 배열 수집: " + Arrays.toString(list));
		
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
		
		System.out.println("배열의 개수: " + list.length);
		
		return "Quiz 3 ok";
		
		// localhost:8080/param/q3?list=a&list=b&list=c
		
	}
	
	// 4, 5, 6번: 복잡한 파라미터는 메시지 바디에 데이터를 담을 것
	// @RequestBody를 사용하여 JSON 형식의 문자열을 클래스로 변환
	// 복잡 -> @RequestParam, @PathVariable 보다는 @RequestBody (JSON 사용)
	
	// POST 요청 + Q4 주소 연결, 메시지 바디 JSON 형식으로 전달된 학생 정보 수집
	@PostMapping("/q4")
	public String quiz2_4(@RequestBody StudentDTO dto) {		
				
		System.out.println("객체 수집: " + dto);
		
		return "Quiz 4 ok";
		
//		{
//			"no": 1,
//			"name": "둘리",
//			"grade": 3
//		}
		
	}
	
	// POST 요청 + Q5 주소 연결, 메시지 바디 JSON 형식으로 전달된 학생 정보 수집
	@PostMapping("/q5")
	public String quiz2_5(@RequestBody ArrayList<StudentDTO> list) {		
				
		System.out.println("객체 타입 리스트 수집: " + list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("리스트의 개수: " + list.size());
		
		return "Quiz 5 ok";
		
//		[
//		    {
//		        "no": 1,
//		        "name": "둘리",
//		        "grade": 3
//		    },
//		    {
//		        "no": 2,
//		        "name": "또치",
//		        "grade": 1
//		    },
//		    {
//		        "no": 3,
//		        "name": "도우너",
//		        "grade": 2
//		    }
//		]
		
	}
	
	// POST 요청 + Q6 주소 연결, 메시지 바디 JSON 형식으로 전달된 학생 정보 수집
	@PostMapping("/q6")
	public String quiz2_6(@RequestBody ArrayList<CarDTO> list) {		
				
		System.out.println("객체 타입 리스트 수집: " + list);
		
		for (CarDTO dto : list) {
			System.out.println(dto);
		}
		
		System.out.println("리스트 마지막 요소: " + list.get(list.size()-1));
		
		return "Quiz 6 ok";
		
//		[
//		    {
//		        "company": "현대",
//		        "model": "코나",
//		        "color": "블랙"
//		    },
//		    {
//		        "company": "기아",
//		        "model": "K3",
//		        "color": "블루"
//		    },
//		    {
//		        "company": "쉐보레",
//		        "model": "스파크",
//		        "color": "화이트"
//		    }
//		]
		
	}

}
