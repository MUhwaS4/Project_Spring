package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DogTest {
	
	@Autowired
	Dog dog;

	@Test
	void 테스트() {
		dog.sound();
	}

}

// 스프링 컨테이너 = 빈을 관리하는 저장소
// 스프링이 빈을 관리하는 방법 1) 객체 생성 후 저장 / 2) 필요한 곳에 주입
// 어떤 상황에서 빈을 사용하는지 = 고유한 값이 없고, 기능만 있는 공통 클래스