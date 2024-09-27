package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;

@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	BoardRepository repository;
	
	@Test
	void 빈확인() {
		System.out.println("리파지토리: "+ repository);
	}
	
	@Test
	void 게시물등록() {
		Board board = Board.builder()
						.name("Select")
						.codename("No. 30")
						.syndrome("우로보로스, 솔라리스")
						.work("군인")
						.dLois("aaa")
						.build();
		
		repository.save(board);
	}
	
	@Test
	void 게시물단건조회() {
		
		Optional<Board> optional = repository.findById(1);
		
		System.out.println(optional);
		
	}
	
	@Test
	void 게시물목록조회() {
		List<Board> list = repository.findAll();
		
		for (Board board : list) {
			System.out.println(board);
		}
	}
	
	@Test
	void 게시물수정() {
		Optional<Board> optional = repository.findById(1);
		
		Board board = optional.get();
		board.setDLois("유산계승자: 성검의 왕자");
		
		repository.save(board);
		
	}
	
	@Test
	void 게시물삭제() {
		repository.deleteById(2);
	}

}
