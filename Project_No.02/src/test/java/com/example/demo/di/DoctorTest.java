package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DoctorTest {
	
	@Autowired
	Doctor doctor;
	
	@Autowired
	
	Hospital doctor2;
	@Autowired
	Hospital hospital;
	
	@Test
	void 테스트() {
		
		System.out.println(doctor);
		System.out.println(doctor2);
		System.out.println(hospital);
		
	}
	
	// + 테스트 클래스에서 선언된 객체와 원본이 같은 객체인지 확인
	// 두 객체의 주소가 같음
	
	@Test
	void 주소테스트() {
		
		System.out.println(doctor2);
		System.out.println(hospital);
		
		System.out.println(doctor);
		System.out.println(hospital.doctor);
	}
	
	
	
	

}
