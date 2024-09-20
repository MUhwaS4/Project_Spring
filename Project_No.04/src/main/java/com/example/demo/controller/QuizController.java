package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.MemberRepository;

@Controller // 해당 클래스를 컨트롤러로 지정하고, 빈으로 등록(Component 효과)
@RequestMapping("/quiz") // 사용자 요청을 /q1 주소에 매핑 (중간경로)
public class QuizController {
	
	MemberRepository repository = new MemberRepository();
	
	// 개인 인적사항을 반환하는 메소드
	
	@GetMapping("/q1") // /quiz/q1
	public String method1() {
		return "/quiz/q1";
		// /src/main/webapp/view/quiz/q1.jsp 파일을 반환
	}
	
	// 인적사항 표를 반환하는 메소드
	
	@GetMapping("/q2") // /quiz/q2
	public String method2() {
		return "/quiz/q2";
		// /src/main/webapp/view/quiz/q2.jsp 파일을 반환
	}

}
