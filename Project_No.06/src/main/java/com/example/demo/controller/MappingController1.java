//package com.example.demo.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//
//// 컨트롤러의 역할: 사용자 요청 처리
//
//@Controller // 컨트롤러 표시 + 빈 등록
//public class MappingController1 {
//	
//	
//	// 주소: GET + /board
//	@ResponseBody // 메시지 바디에 데이터를 직접 담는 기능
////	@RequestMapping(value = "/board", method = RequestMethod.GET) = 하단의 축약 어노테이션과 동일
//	@GetMapping("/board") // 상단의 RequestMapping이 축약된 어노테이션 
//	public String list() {
//		
//		System.out.println("게시물 조회…");
//		return "조회 ok";
//		
//	}
//	
//	// @ResponseBody 설정이 없다면 반환값을 template/ok.html로 인지함 (ok.html 파일이 없을 경우 연결 파일 없음으로 500 에러)
//	// 현재는 "ok"라는 텍스트가 반환됨
//	
//	// 스프링부트는 기본적으로 템플릿 파일을 반환한다.
//	// 순수한 데이터를 반환할 때는 @ResponseBody 어느테이션을 설정해야한다.
//	
//	// 주소: POST + /board
//	@ResponseBody
//	@PostMapping("/board") 
//	// HTTP 메소드 종류가 다르면 URL이 같아도 중복 아님
//	public String save() {
//		
//		System.out.println("게시물 등록…");
//		return "등록 ok";
//		
//	}
//	
//	// 주소: PUT + /board
//	@ResponseBody
//	@PutMapping("/board")
//	public String modify() {
//		
//		System.out.println("게시물 수정…");
//		return "수정 ok";
//		
//	}
//	
//	// 주소: DELETE + /board
//	@ResponseBody
//	@DeleteMapping("/board")
//	public String delete() {
//		
//		System.out.println("게시물 삭제…");
//		return "삭제 ok";
//		
//	}
//
//}
