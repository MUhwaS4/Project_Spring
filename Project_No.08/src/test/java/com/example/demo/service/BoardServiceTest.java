package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.BoardDTO;

@SpringBootTest
public class BoardServiceTest {
	
	@Autowired
	BoardService service;
	
	@Test
	void 게시물등록() {
		
		// 서비스는 DTO를 사용하기 때문에 작성자에 아이디만 넣으면 됨
		BoardDTO dto = BoardDTO.builder()
								.title("하이")
								.content("하이")
								.writer("user1")
								.build();
		
		int no = service.register(dto);
		
		System.out.println("새로운 게시물 번호: " + no);
		
	}

}
