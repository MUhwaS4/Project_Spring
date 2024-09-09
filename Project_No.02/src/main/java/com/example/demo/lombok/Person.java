package com.example.demo.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString // 재정의
@NoArgsConstructor // 디폴트 생성자 (매개변수 없이 객체 생성)
@AllArgsConstructor // 생성자 (모든 매개변수를 입력받아 객체 생성)
@Builder // 생성자
public class Person {
	
	String name;
	int age;

}
