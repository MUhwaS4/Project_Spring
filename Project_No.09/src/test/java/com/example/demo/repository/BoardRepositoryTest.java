package com.example.demo.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;

@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	BoardRepository repository;
	
	@Test
	void 게시물등록_잘못된방법() {
		
		// 작성자 필드에 사용할 회원 엔티티 생성
		// Member를 등록할 목적이 아니기 때문에 PK만 입력하면 됨
		Member member = Member.builder()
								.id("user1")
								.build();
		
		// 회원 테이블에 존재하지 않는 회원을 작성자로 사용하면 에러
		Board board1 = Board.builder()
							.title("에러")
							.content("Member에 존재하지 않는 id로 등록하면 에러")
							.writer(member)
							.build();
		
		repository.save(board1);
		
	}
	
	@Test
	void 게시물등록확인() {
		
		// 테이블에 존재하는 회원 정보로 엔티티 생성
		Member member = Member.builder()
								.id("user1")
								.build();
		
		// 작성자 필드에 회원 정보 입력
		Board board1 = Board.builder()
								.title("안녕하세요")
								.content("안녕하세요")
								.writer(member)
								.build();

		Board board2 = Board.builder()
								.title("반갑습니다")
								.content("반갑습니다")
								.writer(member)
								.build();
		
		repository.save(board1);
		repository.save(board2);
		
	}
	
	@Test
	void 게시물조회() {
		
		Optional<Board> optional = repository.findById(1);
		
		Board board = optional.get();
		
		System.out.println(board);
		
		// SQL 쿼리에서 board 테이블과 member 테이블이 join 처리되어
		// 게시물 정보에 작성자(회원) 정보가 포함됨
		
	}	

}
