package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberRepository repository;

	@Override
	public Page<MemberDTO> getList(int pageNumber) {
		
		// 전달받은 페이지 번호를 인덱스로 변경
		int pageIndex = (pageNumber == 0) ? 0 : pageNumber - 1;
		
		// 정렬 조건 만들기: 등록일을 기준으로 내림차순 정렬
		// Board의 경우 기준: 번호 or 등록일
		// Member의 경우 기준: 등록일
		Sort sort = Sort.by("regDate").descending(); 
		
		// 페이징 조건 만들기
		Pageable pageable = PageRequest.of(pageIndex, 10, sort);
		
		// 회원 목록 조회
		Page<Member> entityPage = repository.findAll(pageable);
		
		// 엔티티 리스트를 DTO 리스트로 변환
		Page<MemberDTO> dtoPage = entityPage.map( entity -> entityToDto(entity));
		
		return dtoPage;
	}

}
