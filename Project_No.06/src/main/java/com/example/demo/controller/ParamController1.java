package com.example.demo.controller;

import java.io.IOException;
import java.util.Locale;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ParamController1 {
	
	@ResponseBody
	@GetMapping("/herder1")
	public String method1(	HttpServletRequest request,
							HttpServletResponse response,
							HttpMethod httpMethod,
							Locale locale,
							@RequestHeader("host") String host) {
		
		System.out.println("request=" + request); // 요청 메시지
		System.out.println("response=" + response); // 응답 메시지
		System.out.println("httpMethod=" + httpMethod); // HTTP 메소드
		System.out.println("locale=" + locale); // 국가
		
		return "method1 ok";
		
	}
	
	@ResponseBody
	@GetMapping("/herder2")
	public void method2(	HttpServletRequest request,
							HttpServletResponse response) throws IOException {
		
		// request 객체를 사용하여 요청메시지에 담긴 파라미터 꺼내기
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age")); // int 타입 형 변환 후 인자 작성
		
		System.out.println("username: " + username);
		System.out.println("age: " + age);
		
		// response 객체를 사용하여 응답 메시지에 데이터 담기
		response.getWriter().write("ok");
		
		// /herder2?username=둘리&age=20
		// 주소 ? key=value & 내용이많을경우 (&)으로 연결 후 다시 key=value
		
	}
	

}
