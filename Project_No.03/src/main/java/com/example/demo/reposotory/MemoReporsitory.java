package com.example.demo.reposotory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Memo;

// 리파지토리: 엔티티를 사용하여 데이터를 처리 (CRUD, 페이징, 정렬)

// CRUD: 작성 Create, 읽기, Read, 업데이트(수정) Update, 삭제 Delete

public interface MemoReporsitory extends JpaRepository<Memo, Integer> { // <엔티티, PK Type>
	
	

}

// JpaRepository를 생성할 때는 [엔티티]와 [해당 엔티티의 PK 타입]을 지정해야 한다