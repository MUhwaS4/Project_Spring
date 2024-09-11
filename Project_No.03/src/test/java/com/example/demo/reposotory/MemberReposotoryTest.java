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
		
		Member member1 = Member
							.builder()
							.user_id("admin")
							.grade("관리자")
							.password("1234")
							.build();
		
		list.add(member1);
		
		Member member2 = Member
							.builder()
							.user_id("user")
							.grade("사용자")
							.password("1234")
							.build();
		
		list.add(member2);
		
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

}
