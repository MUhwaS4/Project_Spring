package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Member;

@SpringBootTest
public class CommentRepositoryTest {
	
	@Autowired
	CommentRepository commentRepository;
	
	@Test
	public void 댓글등록() {
		
		Board board = Board.builder()
								.no(1)
								.build();
		
		Member writer = Member.builder()
								.id("user1")
								.build();
		
		Comment comment = Comment.builder()
									.board(board)
									.content("댓글 추가")
									.writer(writer)
									.build();
		
		commentRepository.save(comment);
		
	}
	
	@Test
	public void 댓글목록조회() {
		
		List<Comment> list = commentRepository.findAll();
		
		for (Comment comment : list) {
			System.out.println(comment);
		}
		
	}
	
	@Test
	public void 댓글단건조회() {
		
		Optional<Comment> optional = commentRepository.findById(1);
		
		Comment comment = optional.get();
		
		System.out.println(optional);
		System.out.println(comment);
		
	}
	
	@Test
	public void 댓글수정() {
		
		Optional<Comment> optional = commentRepository.findById(3);
		
		if (optional.isPresent()) {
			
			Comment comment = optional.get();
			
			comment.setContent("댓글 수정!!!");
			
			commentRepository.save(comment);
			
		}
		
	}
	
	@Test
	public void 댓글삭제() {
		
		commentRepository.deleteById(2);
		
	}
	
	@Test
	public void 게시물별_댓글조회() {
		
		Board board = Board.builder()
							.no(1)
							.build();
		
		List<Comment> list = commentRepository.findByBoard(board);
		
		for (Comment comment : list) {
			System.out.println(comment);
		}
		
	}
	
	@Test
	public void 게시물별_댓글삭제() {
		
		Board board = Board.builder()
							.no(1)
							.build();
		
		commentRepository.deleteByBoard(board);
		
	}
	
}
