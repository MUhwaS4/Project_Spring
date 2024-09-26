package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

// 자식 클래스 중 서비스로 지정
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardRepository repository; // 리파지토리를 빈으로 주입

	@Override
	// 게시물 등록 메소드
	public int register(BoardDTO dto) {
		
		// 전달받은 DTO를 엔티티로 변환
		Board entity = dtoToEntity(dto);
		
		// 엔티티를 테이블에 저장
		repository.save(entity);
		
		// 저장 후 게시물의 번호를 반환
		int newNo = entity.getNo();
		
		return newNo;
		
		// DTO에서 입력받은 내용을 서비스의 함수(dtoToEntity(dto))를 통해 엔티티로 변환
		// 해당 엔티티를 테이블에 저장하고 (BoardRepositoryTest 단위테스트에 있는 게시물 등록과 동일하게 save 함수 사용)
		// 이후 몇 번 게시물로 등록됐는지 번호를 반환하는 과정
		
	}

	@Override
	// 게시물 목록 조회 메소드
	public List<BoardDTO> getList() {
		
		// 데이터베이스에서 게시물 목록 가져오기
		List<Board> result = repository.findAll();
		
		// 엔티티 리스트를 DTO 리스트로 변환하기
		List<BoardDTO> list = new ArrayList<>();
		
		// 리스트에서 스트림 생성하기
		// 스트림을 사용하여 모든 엔티티를 DTO로 변환
		// 함수형 인터페이스는 람다식 함수로 구현한다
		list = result.stream()
				.map(entity -> entityToDto(entity))
				.collect(Collectors.toList());
		
		return list; // 변환한 DTO 리스트 반환
		
	}

	@Override
	// 게시물 상세 조회 메소드
	public BoardDTO read(int no) {

		// 게시물 번호로 글 가져오기
		Optional<Board> optional = repository.findById(no);
		
		// 값이 있는지 확인
		if (optional.isPresent()) {
			Board board = optional.get();
			BoardDTO dto = entityToDto(board);
			return dto;
		}
		
		return null;
	}

	@Override
	// 게시물 수정 메소드
	public void modify(BoardDTO dto) {
		
		// 전달받은 DTO에서 게시물 번호를 꺼내고, DB에 존재하는지 확인
		
		int no = dto.getNo();
		
		Optional<Board> optional = repository.findById(no);
		
		if (optional.isPresent()) {
			Board board = optional.get();
			
			// 기존 엔티티에서 제목, 내용, 작성자 변경
			board.setTitle(dto.getTitle());
			board.setContent(dto.getContent());
			board.setWriter(dto.getWriter());
			
			// 데이터베이스에 업데이트
			repository.save(board);
			
		}
		
	}
	
	
}

