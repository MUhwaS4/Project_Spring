package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.UserDTO;

@Controller
@RequestMapping("/param3")
public class ParamController3 {
	
	// 폼 화면을 반환하는 메소드
	@GetMapping("/register")
	public String ex1() {
		return "/param/register";
	}
	
	// 폼에서 전달받은 데이터를 확인하는 메소드
	@ResponseBody
	@PostMapping("/register")
	public String ex2(UserDTO userDTO) {
		System.out.println("UserDTO: " + userDTO);
		return "OK";
	}

}
