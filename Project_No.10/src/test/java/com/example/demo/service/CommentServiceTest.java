package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.CommentDTO;

@SpringBootTest
public class CommentServiceTest {
	
	@Autowired
	CommentService service;
	
	@Test
	public void 댓글등록() {
		
		CommentDTO dto = CommentDTO.builder()
									.boardNo(2)
									.content("시간도없어")
									.writer("qqq")
									.build();
		
		service.register(dto);
		
	}

}
