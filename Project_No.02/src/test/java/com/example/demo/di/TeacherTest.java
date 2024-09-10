package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeacherTest {
	
	// Teacher 타입의 빈 등록하기
	// Teacher를 상속받은 구현체 중 선택
	// 선택 방법: 해당 클래스에 @ Component 붙이기 (택1)
	
	@Autowired
	Teacher t1;
	// Teacher 타입의 빈 찾기
	// 수학 선생님과 과학 선생님은 Teacher 인터페이스를 상속받았으므로 Teacher 타입의 빈에 해당
	
	@Test
	void 테스트() {
		
		t1.teach();
		
	}

}

// 선생님을 호출하면 과학 선생님이 호출됨
// 둘 다 같은 Teacher 타입을 공유하기 때문에(부모) 과학 선생님과 수학 선생님을 동시에 호출할 순 없음

// 과학 선생님과 수학 선생님 중 하나만 호출 가능하고,
// 다른 과목으로 변경하고 싶다면 [교체]해야 함
