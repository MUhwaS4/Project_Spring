package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.entity.Member;

public interface BoardService {
	
	// Service의 목적
	
	// 1. 비즈니스 로직 처리
	// ex_ 회원가입: 아이디 validation
	// 첫 번째 방식: 아이디 10글자 이내
	// 두 번째 방식: 아이디 8글자 이내 + 대문자 포함
	
	// 2. 데이터 가공
	
	// 유연하게 코드를 변경할 수 있도록 (register) + 디폴트 함수는 반복적으로 사용할 수 있어 유지보수에 유리하기에 인터페이스 파일로 설정
	

	// 게시물 등록 메소드
	int register(BoardDTO dto);
	
	// 게시물 목록 조회 메소드
//	List<BoardDTO> getList();
	// 페이지 번호를 받아서 특정 페이지의 번호를 반환하도록 수정
	Page<BoardDTO> getList(int pageNumber);
	
	// 게시물 상세 조회 메소드
	BoardDTO read(int no);
	
	// 게시물 수정 메소드
	void modify(BoardDTO dto);
	
	void remove(int no);
	
	// 컨트롤러가 DTO를 받아서 서비스에 전달하고
	// 서비스는 DTO를 Entity로 변환해서 리파지토리에 전달
	
	// default 키워드: 인터페이스에서 일반 함수를 추가하는 기능
	// DTO -> entity 변환하는 메소드
	default Board dtoToEntity(BoardDTO dto) {
		
		// DTO에서 꺼낸 문자열을 Member 객체로 감싸고
		// 그 후에 작성자 필드에 사용
		
		Member member = Member.builder()
								.id(dto.getWriter())
								.build();
		
		Board entity = Board.builder()
							.no(dto.getNo())
							.title(dto.getTitle())
							.content(dto.getContent())
							.writer(member)
							.build();
		
		// dto에 있는 데이터를 하나씩 꺼내서 entity로 옮기는 과정
		// dto가 entity라는 경로를 이용해 리파지토리에 저장되므로 저장 날짜 같은 건 생략 가능 
		
		return entity;
		
	}
	
	// entity -> DTO 변환하는 메소드
	default BoardDTO entityToDto(Board entity) {
		
		BoardDTO dto = BoardDTO.builder()
								.no(entity.getNo())
								.title(entity.getTitle())
								.content(entity.getContent())
								.writer(entity.getWriter().getId())
								.regDate(entity.getRegDate())
								.modDate(entity.getModDate())
								.build();
		
		// entity에 있는 데이터를 하나씩 꺼내서 dto로 바꿔서 꺼내는 과정
		// entity에 있는 데이터 중 하나라도 누락하면 에러
		
		return dto;
		
	}

}
