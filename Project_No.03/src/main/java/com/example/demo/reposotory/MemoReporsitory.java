package com.example.demo.reposotory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Memo;

import jakarta.transaction.Transactional;

// 리파지토리: 엔티티를 사용하여 데이터를 처리 (CRUD, 페이징, 정렬)

// CRUD: 작성 Create, 읽기, Read, 업데이트(수정) Update, 삭제 Delete

@Transactional
public interface MemoReporsitory extends JpaRepository<Memo, Integer> { // <엔티티, PK Type>
	
	// 아래는 쿼리 메소드 진도 에서 추가한 내용
	
	// 메모의 번호가 10에서 20 사이인 데이터 검색
	// 검색에 필요한 파라미터는 매개변수로 선언
	
	// find by(기준)(연산자): 조회, 바로 뒤에 있는 기준을 찾아서 연산자 확인  	

	// … where no between ?1 and ?2
	List<Memo> findByNoBetween(int from, int to);
	// No: 기준 / Between: 연산자
	
	// 메모의 번호가 10보다 작은 데이터 검색
	// ... where no < ?
	List<Memo> findByNoLessThan(int mno);
	// LessThan = 비교부등호 / 따라서 이걸 파라미터로 받을 것
	
	// 메모의 내용이 없는 데이터 검색
	// ... where text is not null
	List<Memo> findByTextIsNotNull();
	
	// 메모의 번호를 기준으로 역정렬
	// ... order by no desc
	List<Memo> findAllByOrderByNoDesc();
	
	// 메모의 번호가 3보다 작은 데이터 삭제
	// delete from tbl_memo where no < ?
	void deleteMemoByNoLessThan(int mno);
	

}

// JpaRepository를 생성할 때는 [엔티티]와 [해당 엔티티의 PK 타입]을 지정해야 한다