package com.example.demo.di;

public class MathTeacher implements Teacher {

	@Override
	public void teach() {
		System.out.println("수학 선생님이 수업을 가르칩니다.");
		
	}

}

// 추상 메소드가 있는 인터페이스를 부모로 받아 함수 오버라이드
// 의존성 설정은 A 객체가 여러 개 있다면 1개만 설정 가능
// 과학 선생님에 설정했으므로 수학 선생님은 적용 안 됨
// 의존성 설정은 교체 가능