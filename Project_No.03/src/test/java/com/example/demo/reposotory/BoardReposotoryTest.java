package com.example.demo.reposotory;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;

@SpringBootTest // 없으면 일반 클래스가 되기 때문에 실행을 위해서 추가
public class BoardReposotoryTest {
	
	@Autowired // 없으면 객체를 가져올 수 없기 때문에 항목이 null 값이 되므로 추가
	BoardReposotory boardReposotory;
	
	@Test // 없으면 단위 테스트 실행 불가이므로 추가
	public void 리파지토리객체를가져왔는지확인() {
		
		System.out.println("boardReposotory = " + boardReposotory);
		
	}
	
	@Test
	public void 데이터등록() {
		
		Board board1 = Board.builder()
									.title("1번 글") // 제목
									.content("내용입니다.") // 내용
									.build();
		
		boardReposotory.save(board1);
		
		Board board2 = Board.builder()
									.title("2번 글") // 제목
									.content("내용입니다.") // 내용
									.build();
		
		boardReposotory.save(board2);
		
	}
	
	@Test
	public void 데이터단건조회() {
		
		Optional<Board> result = boardReposotory.findById(1); // fidnById는 PK의 값
		
		if (result.isPresent()) {
			Board board = result.get();
			System.out.println(board);
		}
		
	}
	
	@Test
	public void 데이터전체조회() {
		
		// findAll: 테이블에 있는 모든 데이터를 조회하는 함수
		// 찾고자 하는 데이터를 list에 저장
		List<Board> list = boardReposotory.findAll();
		
		// 이후 람다식 포문으로 하나씩 출력
		for (Board board : list) {
			System.out.println(board);
		}
		
	}
	
	@Test
	public void 데이터수정() {
		
		Optional<Board> result = boardReposotory.findById(1);
		Board board = result.get();
		board.setContent("내용이 수정되었습니다~.");
		
		// save 함수는 추가 또는 수정을 처리한다
		boardReposotory.save(board);
		
	}
	
	@Test
	public void 데이터단건삭제() {
		
		boardReposotory.deleteById(1);
		
	}
	
	@Test
	public void 데이터전체일괄삭제() {
		boardReposotory.deleteAll(); // 매개변수 없음
	}

}