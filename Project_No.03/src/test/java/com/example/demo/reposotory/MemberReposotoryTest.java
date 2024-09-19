package com.example.demo.reposotory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;

@SpringBootTest
public class MemberReposotoryTest {
	
	@Autowired
	MemberReposotory memberReposotory;
	
	@Test
	public void 객체조회() {
		System.out.println(memberReposotory);
	}
	
	@Test
	public void 데이터조회() {
		Optional<Member> optional = memberReposotory.findById("admin");
		
		if (optional.isPresent()) {
			Member member = optional.get();
			System.out.println(member);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		List<Member> list = memberReposotory.findAll();
		
		for (Member member : list) {
			System.out.println(member);
		}
	}
	
	@Test
	public void 데이터추가() {
		List<Member> list = new ArrayList<>();

		// 4번 문제. 데이터 자료형: LocalDate
		// 시스템이 현재 시간을 자동으로 저장 (JPA 기능 활용)
		
		Member member1 = Member
							.builder()
							.user_id("admin")
							.grade("관리자")
							.password("1234")
							.build();
		
		list.add(member1);
		
		Member member2 = Member
							.builder()
							.user_id("user1")
							.grade("사용자")
							.password("1234")
							.build();
		
		list.add(member2);
		
		Member member3 = Member
							.builder()
							.user_id("yoyt22")
							.grade("관리자")
							.password("1234")
							.build();
		
		list.add(member3);
		
		Member member4 = Member
							.builder()
							.user_id("user2")
							.grade("사용자")
							.password("1234")
							.build();
		
		list.add(member4);
		
		memberReposotory.saveAll(list);
		
	}
	
	@Test
	public void 데이터수정() {
		Optional<Member> optional = memberReposotory.findById("user");
		Member member = optional.get();
		member.setPassword("123444");
		memberReposotory.save(member);
	}
	
	@Test
	public void 데이터삭제() {
		memberReposotory.deleteById("user");
	}
	
	// Q8.
	
	@Test
	public void Q8아이디검색() {
		List<Member> list = memberReposotory.getQuiz81("user");
		
		for (Member member : list) {
			System.out.println(member);
		}
	}
	
	@Test
	public void Q8관리자검색() {
		List<Member> list = memberReposotory.getQuiz82("관리자");
		
		for (Member member : list) {
			System.out.println(member);
		}
	}

}
