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

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardRepository repository;

	// 게시글 등록
	@Override
	public int register(BoardDTO dto) {
		
		Board entity = dtotoEntity(dto);
		
		repository.save(entity);
		
		int newNo = entity.getNo();
		
		return newNo;
	}

	// 목록 조회
	@Override
	public List<BoardDTO> getList() {
		
		List<Board> result = repository.findAll();
		
		List<BoardDTO> list = new ArrayList<>();
		
		list = result.stream()
						.map(entity -> entitytoDto(entity))
						.collect(Collectors.toList());
		
		return list;
	}

	// 단건 조회
	@Override
	public BoardDTO read(int no) {
		
		Optional<Board> optional = repository.findById(no);
		
		if (optional.isPresent()) {
			Board board = optional.get();
			BoardDTO dto = entitytoDto(board);
			return dto;
		}
		
		return null;
	}

	// 수정
	@Override
	public void modify(BoardDTO dto) {
		
		int no = dto.getNo();
		
		Optional<Board> optional = repository.findById(no);
		
		if (optional.isPresent()) {
			Board board = optional.get();
			
			board.setName(dto.getName());
			board.setCodename(dto.getCodename());
			board.setWork(dto.getWork());
			board.setDLois(dto.getDrois());
			
			repository.save(board);
			
		}
		
	}

	// 게시글 삭제
	@Override
	public void remove(int no) {
		
		Optional<Board> optional = repository.findById(no);
		
		if (optional.isPresent()) {
			repository.deleteById(no);
		}
		
	}

}
