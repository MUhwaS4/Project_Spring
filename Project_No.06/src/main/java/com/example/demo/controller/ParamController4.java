package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.BookDTO;

@Controller
@RequestMapping("/param4")
public class ParamController4 {

	//GET localhost:8080/param4/ex1 + json
	@ResponseBody
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

}
