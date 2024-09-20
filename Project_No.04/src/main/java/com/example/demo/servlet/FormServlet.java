package com.example.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// HTTP 메시지: 브라우저와 서버 간의 데이터를 주고받기 위한 형식
// request(요청)과 response(응답) 메시지로 나뉨

// 자바 웹 기술의 발전 순서: 서블릿 → JSP → MVC패턴 → 프론트 컨트롤러 패턴 → 스프링MVC



// 서블릿 (Servlet): HTTP 요청과 응답을 처리하는 기본적인 웹 기술.

// 서블릿: 서버에 사용자 요청을 전송하면 응답을 생성해서 리턴
// 사용자 요청 확인 > request, response 객체 생성
	// request: 사용자 요청 정보 분석
	// response: 응답 생성
// 이 과정에서 HTTP 메시지 자동 생성 후 사용자에게 전송

// 회원 등록 폼을 전송할 서블릿 만들기

// HttpServlet 클래스를 상속받고, 서블릿 이름과 URL 설정
@WebServlet(name = "FormServlet", urlPatterns = "/servlet/form")
public class FormServlet extends HttpServlet {
	
	// 1. HttpServlet를 상속받는다
	// 2. service 함수를 재정의하여 사용자 요청을 처리한다 (우클릭 > 소스 > 오버라이드 > 서비스(노랑))
	// 메인 파일에 @ServletComponentScan 어노테이션 설정

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 응답 메시지 설정 (컨텐츠 타입과 문자 인코딩)
		resp.setContentType("text/html"); // HTML, JSON, XML…
		resp.setCharacterEncoding("utf-8");
		
		// 응답 데이터를 작성하기 위해 writer 객체 생성
		PrintWriter w = resp.getWriter();
		
		// 회원 정보를 입력할 수 있는 HTML form 태그를 만들어서 응답에 추가
		w.write("<!DOCTYPE html>\n" +
				"<html>\n" +
				"<head>\n" +
				" <meta charset=\"UTF-8\">\n" +
				" <title>회원 등록</title>\n" +
				"</head>\n" +
				"<body>\n" +
				"<form action=\"/servlet/save\" method=\"post\">\n" + // 폼을 전송할 주소
				" 이름: <input type=\"text\" name=\"username\" />\n" + // 이름 입력 필드
				" 암호: <input type=\"text\" name=\"password\" />\n" + // 패스워드 입력 필드
				" <button type=\"submit\">전송</button>\n" + // 전송 버튼
				"</form>\n" +
				"</body>\n" +
				"</html>\n");
		
		// name: getParameter에서 사용할 key
		// id는 프론트(CSS, JS)에서, name은 백에서 사용
		
	}

}
