package com.example.demo.optional;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OptionalTest {
	
	// Optional 클래스는 null값을 안전하게 처리하기 위한 클래스
	// 값의 존재여부에 따라 로직을 처리할 것
	
	@Test
	void Optional사용하기() {
		
		String str = "apple";
		Optional<String> opt = Optional.of(str);
		// 객체 생성, of가 생성자 역할을 해줌
		// of 함수: 값을 입력받아서 객체를 생성하는 함수
		
		System.out.println("Optional에서 값 꺼내기: " + opt.get());
		System.out.println("Optional에서 안에 값이 없는지?: " + opt.isEmpty());
		System.out.println("Optional에서 안에 값이 있는지?: " + opt.isPresent());
		
		// Optional = 제네릭 타입 
		
		// ofNullable 함수는 of 함수와 달리 빈 값도 저장할 수 있음!
		String str2 = null;
		Optional<String> opt2 = Optional.ofNullable(str2);
		
	}
	
	@Test
	void of와ofNullable의차이() {
		
		// of: Optional 객체를 생성하는 함수. null 입력 불가.
		// ofNullable: Optional 객체를 생성하는 함수. null 입력 가능.
		
		String str = null;
//		Optional<String> opt1 = Optional.of(str); // 에러
		Optional<String> opt2 = Optional.ofNullable(str);
		
	}
	
	@Test
	void 빈객체를사용하는경우() {
		
		// Optional 객체를 생성하고 빈값을 저장
		Optional<String> opt = Optional.ofNullable(null);
		
		// 객체 안에 있는 값 꺼내기
		System.out.println(opt.get()); // 에러
		
		// if문(조건문)를 사용하여 null값 체크하기
		if(opt.isPresent() == true) {
			// 객체 안에 있는 값 꺼내기
			System.out.println(opt.get());
		} else {
			System.out.println("값이 없습니다.");
		}
		
		// isPresent 함수를 이용하여 빈값 체크하기
		opt.ifPresent(t-> System.out.println(t+"값이 존재합니다."));
		
	}

}