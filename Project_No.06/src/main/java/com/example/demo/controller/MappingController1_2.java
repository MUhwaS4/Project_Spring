package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 공통 URL
@RequestMapping("/board") // 모든 매핑 메소드 어노테이션이 같은 주소를 지정하므로 이렇게 축약 가능
@Controller
public class MappingController1_2 {
	
	
	// 주소: GET + /board
	@ResponseBody
	@GetMapping
	public String list() {
		
		System.out.println("게시물 조회…");
		return "조회 ok";
		
	}
	
	// 주소: POST + /board
	@ResponseBody
	@PostMapping 
	public String save() {
		
		System.out.println("게시물 등록…");
		return "등록 ok";
		
	}
	
	// 주소: PUT + /board
	@ResponseBody
	@PutMapping
	public String modify() {
		
		System.out.println("게시물 수정…");
		return "수정 ok";
		
	}
	
	// 주소: DELETE + /board
	@ResponseBody
	@DeleteMapping 
	public String delete() {
		
		System.out.println("게시물 삭제…");
		return "삭제 ok";
		
	}

}
