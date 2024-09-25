package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookDTO;

@RestController // @Controller + @ResponseBody가 포함됨
@RequestMapping("/param4")
public class ParamController4 {

	//GET localhost:8080/param4/ex1 + json
	
	@GetMapping("/ex1")
	public String ex1(@RequestBody BookDTO dto) {
		
		System.out.println("메시지 바디: " + dto);
		
		return "ok";
		
		// postman > body > raw + json 형태로 추가 작성하고 연결해야 오류 없음
		//{
		//"title": "자바프로그래밍입문",
		//"publisher": "한빛컴퍼니",
		//"price": 20000
		//}

		
	}
	
	@GetMapping("/ex2")
	public String ex(@RequestBody ArrayList<BookDTO> list) {
		System.out.println("메시지 바디에 담긴 리스트 수집: " + list);
		return "ok";
	}
	
	// JSON 형식
	// 배열 또는 리스트 => []
	// 객체 => {}
	// 객체 타입의 리스트 => [{}, {}, {}]
	
//	[
//	    {
//	        "tit": "자바프로그래밍입문",
//	        "publisher": "한빛컴퍼니",
//	        "price": 20000
//	    },
//	    {
//	        "title": "스프링부트웹프로젝트",
//	        "publisher": "구멍가게코딩단",
//	        "price": 15000
//	    },
//	    {
//	        "title": "모두의리눅스",
//	        "publisher": "길벗출판사",
//	        "price": 10000
//	    }
//	]

}
