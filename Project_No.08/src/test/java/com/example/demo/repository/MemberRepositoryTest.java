package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;

@SpringBootTest
public class MemberRepositoryTest {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	BoardRepository boardRepository;
	
	@Test
	public void 회원등록() {
		
		Member member1 = Member.builder()
								.id("user1")
								.name("둘리")
								.password("1234")
								.build();
		
		Member member2 = Member.builder()
								.id("user2")
								.name("또치")
								.password("1234")
								.build();
		
		Member member3 = Member.builder()
								.id("user3")
								.name("짱구")
								.password("1234")
								.build();
		
		memberRepository.save(member1);
		memberRepository.save(member2);
		memberRepository.save(member3);
		
	}
	
	@Test
	public void 회원목록조회() {
		
		List<Member> list = memberRepository.findAll();
		
		for (Member member : list) {
			System.out.println(member);
		}
		
	}
	
	@Test
	public void 회원단건조회() {
		
		Optional<Member> result = memberRepository.findById("user1");
		
		if (result.isPresent()) {
			System.out.println(result);
		}
		
	}
	
	@Test
	public void 회원수정() {
		
		Optional<Member> result = memberRepository.findById("user3");
		
		if (result.isPresent()) {
			
			Member member = result.get();
			
			member.setName("이름 수정");
			
			memberRepository.save(member);
			
		}
		
	}
	
	@Test
	public void 회원삭제() {
		
		memberRepository.deleteById("user3");
		
	}
	
	@Test
	public void 첫번째회원삭제() {
		
		// 첫 번째 회원의 경우 이미 가지고 있는 게시글 데이터가 있기 때문에
		// 회원을 삭제하려면 먼저 가지고 있던 게시글 데이터을 삭제해야 함
		
		memberRepository.deleteById("user1");
		
		// 데이터 추가: 부모 > 자식
		// 데이터 삭제: 자식 > 부모
		
	}
	
	@Test
	public void 두번째회원삭제() {
		
		// 게시글을 작성하지 않은 두 번째 회원은 사전 과정을 거치지 않고 삭제 가능
		
		memberRepository.deleteById("user2");
		
	}
	
	@Test
	public void 회원삭제_게시물포함() {
		
		// 회원 엔티티로 데이터를 추가할 때: 모든 데이터 작성
		// 회원 엔티티를 이용할 때: PK만 작성
		Member member = Member.builder()
								.id("user1")
								.build();
		
		// 해당 회원이 작성한 모든 글을 삭제
		boardRepository.deleteWriter(member);
		
		// 그 후에 회원을 삭제
		memberRepository.deleteById("user1");
		
	}
	
	@Test
	public void 회원일괄등록() {
		List<Member> list = new ArrayList<>();
		
		for (int i = 1; i <= 30; i++) {
			list.add(new Member("user"+i, "1234", "둘리"));
		}
		
		memberRepository.saveAll(list);
		
	}

}
