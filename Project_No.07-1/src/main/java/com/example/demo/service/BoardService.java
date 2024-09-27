package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;

public interface BoardService {
	
	// 입력한 DTO를 바탕으로 데이터베이스에 입력
	int register(BoardDTO dto);
	
	// 화면에 DTO를 불러와야하므로 속성도 DTO
	List<BoardDTO> getList();
	
	// id 번호에 맞춰서 상세 조회, 조회는 DTO를 불러올 것
	BoardDTO read(int no);
	
	// 수정을 위해서 기본적으로 DTO 호출
	void modify(BoardDTO dto);
	
	// id 번호에 맞춰서 조회하고 삭제
	void remove(int no);
	
	// DTO를 Entity로 변환
	default Board dtotoEntity(BoardDTO dto) {
		
		Board entity = Board.builder()
							.name(dto.getName())
							.codename(dto.getCodename())
							.syndrome(dto.getSyndrome())
							.work(dto.getWork())
							.dLois(dto.getDrois())
							.build();
		
		return entity;
		
	}
	
	// entity를 dto로 변환
	default BoardDTO entitytoDto(Board entity) {
		
		BoardDTO dto = BoardDTO.builder()
								.no(entity.getNo())
								.name(entity.getName())
								.codename(entity.getCodename())
								.syndrome(entity.getSyndrome())
								.work(entity.getWork())
								.drois(entity.getDLois())
								.regDate(entity.getRegDate())
								.modDate(entity.getModDate())
								.build();
		
		return dto;
		
	}

}
