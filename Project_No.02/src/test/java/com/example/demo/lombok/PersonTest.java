package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // 스프링 컨테이너 환경
public class PersonTest {
	
	@Test // 단위 테스트(메소드 생성)
	void 롬복테스트() {
		// 기본적으로 함수명은 영어가 기본이지만
		// 단위 테스트는 개발자가 눈으로 확인하기 위함이므로 언어 구분 없음, 한글로 써도 괜찮음
		
		Person person1 = new Person(); // 디폴트생성자
		person1.setName("둘리"); // setter
		person1.setAge(12);
		System.out.println(person1.getName()); // getter
		System.out.println(person1.getAge()); // getter
		
		// 모든 멤버를 입력받는 생성자
		Person person2 = new Person("또치", 15);
		// 제정의된 toString
		System.out.println(person2.toString());
		
		// builder: 메소드 체인 패턴으로 객체를 생성하는 생성자
		// 값을 선택하여 입력할 수 있음
		Person person3 = Person // 객체
							.builder() // 준비
							.name("도우너") // 필드
							.age(17) // 필드
							.build(); // 객체 생성
		
		System.out.println(person3);
		
	}

}
