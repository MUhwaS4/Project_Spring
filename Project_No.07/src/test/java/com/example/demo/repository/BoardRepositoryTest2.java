package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Board;

@SpringBootTest
public class BoardRepositoryTest2 {
	
	@Autowired
	BoardRepository repository;
	
	@Test
	public void 테스트용게시물30개추가() {
		
		for (int i = 1; i<=30; i++) {
			
			Board board = Board.builder()
							.title(i + "번글")
							.content("안녕하세요")
							.writer("둘리")
							.build();
							
			repository.save(board);
			
		}

	}
	
	@Test
	public void 페이징테스트() {
		
		// Pageable: 페이징 처리 조건
		// 1번 페이지에서 게시물 10건 설정
		Pageable pageable = PageRequest.of(0, 10); // 페이지 번호, 개수
		
		// 페이징 조건을 사용하여 목록 조회
		// Page: 게시물 목록 + 페이지 정보
		Page<Board> result = repository.findAll(pageable);
		
		// 전체페이지 정보 출력
		System.out.println(result);
		
		// 게시물 리스트만 출력
		List<Board> list = result.getContent();
		System.out.println(list);

	}
	
	@Test
	public void 정렬조건추가하기() {
		
		// no 필드를 기준으로 내림차순으로 정렬
		// 1~30이 아니라 30~1 순서로 정렬
		Sort sort = Sort.by("no").descending();
		
		// 페이지 번호, 데이터 개수, 정렬 조건
		// 페이지 1장에 데이터 10개 담김
		// 1번: 30~21 / 2번: 20~11 / 3번: 10~1
		Pageable pageable = PageRequest.of(2, 10, sort);
		
		// 페이지에 저장된 데이터 저장
		Page<Board> result = repository.findAll(pageable);
		
		// 저장된 데이터를 리스트에 입력
		List<Board> list = result.getContent();
		
		// 람다식 함수로 게시물 출력
		for (Board b : list) {
			System.out.println(b);
		}
	}

}
