package com.example.demo.di;

import org.springframework.stereotype.Component;

@Component
public class Dog {
	
	public void sound() {
		System.out.println("왕왕 짖는다.");
	}

}

// 객체 생성 방법
// 1. 클래스 설계
// 2. 객체 생성
//		new 생성자
//		build 함수
//		@컴포넌트 (이후 오토라이드로 다른 파일에서 호출 가능)