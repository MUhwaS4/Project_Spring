package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;

// 스프링 컨테이너 환경을 임시로 불러오는 기능
@SpringBootTest
public class BoardRepositoryTest {
	
	// CRUD 가능: 등록, 조회, 수정, 삭제
	
	// 컨테이너 안에 있는 리파지토리 빈 주입
	@Autowired
	BoardRepository repository;
	
	@Test // 단위 테스트
	void 리파지토리빈_확인() {
		System.out.println("repository: " + repository);
	}
	
	@Test
	void 게시물등록() {
		
		Board board = Board.builder()
							.title("3번 글")
							.content("내용입니다.")
							.writer("짱아")
							.build();
		
		// tbl_board 테이블에 데이터 등록하기
		repository.save(board);
		
	}
	
	@Test
	void 게시물목록조회() {
		
		// 리스트로 리파지토리 목록 저장
		List<Board> list = repository.findAll();
		
		// 이후 람다식 for문으로 출력
		for (Board board : list) {
			System.out.println(board);
		}
		
	}
	
	@Test
	void 게시물단건조회() {
		
		// 옵셔널<클래스> = 아이디 조회로 대상 지정
		Optional<Board> post = repository.findById(1);
		
		// 빈 값이 아닌지 확인 후 출력
		if (post.isPresent()) {
			System.out.println(post);
		}
		
	}
	
	@Test
	void 게시물수정() {
		
		// 옵셔널<클래스> = 아이디 조회로 대상 지정
		Optional<Board> result = repository.findById(2);
		
		// 내용 불러오기
		Board board = result.get();
		
		// 이후 원하는 수정 항목 세팅
		board.setContent("내용을 수정했습니다!");
		
		// 수정 내용 저장(업데이트)
		repository.save(board);
		
	}
	
	@Test
	void 게시물삭제() {
		
		repository.deleteById(3);
		
	}

}
