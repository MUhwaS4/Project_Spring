package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManagerTest {
	
	@Autowired
	Cafe cafe;
	
	@Autowired
	Cafe manager;
	
	@Autowired
	Manager manager2;
	
	@Test
	void 테스트() {
		
		System.out.println(cafe);
		System.out.println(manager);
		System.out.println(manager2);
		
	}
	
	// + 테스트 클래스에서 선언된 객체와 원본이 같은 객체인지 확인
	// 두 객체의 주소가 같음
	
	@Test
	void 주소테스트() {
		System.out.println(cafe);
		System.out.println(manager);
		// 둘 다 Cafe의 객체를 불러온 것이기 때문에 변수명은 다르지만 공통된 객체와 주소값을 가지고 있음
		
		System.out.println(manager2);
		System.out.println(cafe.manager);
		// manager2는 Manager의 객체를 불러온 것, cafe.manager는 Cafe 내에서 오토라이드한 manager를 불러온 것
		// 둘 다 동일한 Manager의 객체이기 때문에 동일한 주소값을 가지고 있음
	}

}
