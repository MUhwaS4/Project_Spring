package com.example.demo.reposotory;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Memo;

@SpringBootTest
public class MemoReporsitoryTest1_2 {
	
	@Autowired
	MemoReporsitory reporsitory;
	
	@Test
	void 객체확인() {
		System.out.println(reporsitory);
	}
	
	@Test
	void 메모데이터100개등록() {
		
		// rangeClosed: 1~100 범위의 100개 크기의 스트림 생성
		// forEach: 특정 작업을 수행하는 함수
		
		// 1부터 100까지의 숫자를 포함하는 스트림을 생성하고, 1부터 100까지의 숫자를 하나씩 출력
		IntStream.rangeClosed(1,100).forEach(i -> System.out.println(i));
		
		// 메모 100개를 생성해서 테이블에 추가
		IntStream
			.rangeClosed(1, 100)
			.forEach(value -> {
				Memo memo = Memo.builder().text("Sample. " + value).build();
				reporsitory.save(memo);
			});;
	}
	
	@Test
	void 페이징처리() {
		
		// Pageable: 페이지 번호, 데이터 개수를 담아서 조건을 생성
		// of: Pageable 객체를 생성하는 함수
		Pageable pageable = PageRequest.of(0,  10);
		
		// reporsitory에 있는 모든 데이터를 페이지 형태로 변환
		Page<Memo> page = reporsitory.findAll(pageable);
		// 변수를 쓸 때는 메소드 선언부 참고
		
		// 결과에서 실제 데이터 꺼내기
		List<Memo> list = page.getContent();
		
		System.out.println(list);
		
		// 페이징 처리를 하면 Sql에 limit이 추가된다
		// 이때 Sql의 limit절은 "LIMIT 0, 10"이 된다
		// 만약 두 번째 페이지를 조회한다면 LIMIT절은 "LIMIT 10, 10"이 된다.
		
		// 페이지 부가 정보
		System.out.println("총 페이지: " + page.getTotalPages());
		System.out.println("현재 페이지 번호: " + page.getNumber());
		System.out.println("페이지당 데이터 개수: " + page.getSize());
		System.out.println("다음 페이지 존재 여부: " + page.hasNext());
		System.out.println("시작 페이지 여부: " + page.isFirst());
		
	}
	
	@Test
	void 정렬조건추가하기() {
		
		// no 필드를 기준으로 역정렬하는 조건을 생성
		// 역정렬: 최신글을 먼저 표시 (보편적인 게시판의 구조)
		Sort sort = Sort
						.by("no") // 기준: 
						// by() 메소드의 호출 타입은 Sort,
						// 매개변수는 부르고자하는 엔티티에 있는 컬럼 key
						.descending(); // 정렬방식
						// .ascending()은 순정렬
		
		// 페이징 조건에 정렬 방식 추가
		Pageable pageable = PageRequest.of(0, 10, sort);
		
		// 페이지 조건을 전달하여 데이터 조회
		Page<Memo> page = reporsitory.findAll(pageable);
		
		// 결과에서 실제 데이터만 떠내기
		List<Memo> list = page.getContent();
		
		for (Memo memo : list) {
			System.out.println(memo);
		}
		
		// 정렬 조건을 추가하여 Sql에 order by절이 추가됨
		
		// Page<T>는 조건을 걸어서 내역 출력 가능
		// List<T>는 조건 없이 들어있는 데이터를 모두 출력
		// Page<T> page = 리파지토리.findAll(조건)을 통해 만든 내역을 List<T> list = page.getContent();로 출력 가능
		
	}

}