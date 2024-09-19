package com.example.demo.domain;

import org.junit.jupiter.api.Test;

public class MemberRepositoryTest {
	
	// 스프링을 사용하지 않았기 때문에 직접 리파지토리 객체 생성해야 함
	MemberRepository repository = new MemberRepository();
	
	@Test
	public void 테스트() {
		
		// 1. 회원 등록 (2명)
		// 2. 회원 목록 조회
		// 3. 1번째 회원 조회
		// 4. 모든 회원 삭제
		
		// 회원 등록
		
		Member member1 = Member
								.builder()
								.userId("user1")
								.password("1234")
								.build();
		
		Member member2 = Member
								.builder()
								.userId("user2")
								.password("2234")
								.build();

		repository.save(member1);
		repository.save(member2);
		System.out.println("회원이 추가되었습니다!");
		
		// 회원 목록 조회
		System.out.println(repository.findAll());
		System.out.println("회원 목록을 조회합니다.");
		
		// 1번째 회원 조회
		System.out.println(repository.findById(1));
		System.out.println("회원을 조회합니다.");
		
		// 모든 회원 삭제
		repository.clearStore();
		System.out.println("모든 회원 정보가 삭제되었습니다.");
		
		
		
	}

}
