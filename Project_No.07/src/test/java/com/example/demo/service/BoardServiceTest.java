package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.dto.BoardDTO;

@SpringBootTest // 스프링 컨테이너 환경을 임시로 생성
public class BoardServiceTest {
	
	@Autowired // 컨테이너에서 빈 주입받기
	BoardService service;
	
	@Test
	public void 빈이주입되었는지확인() {
		System.out.println("service: " + service);
	}
	
	@Test
	public void 게시물등록() {
		
		BoardDTO dto = BoardDTO.builder()
								.title("1번 글")
								.content("내용입니다.")
								.writer("둘리")
								.build();
		
		// dto를 엔티티로 변환하는 메소드, 반환값은 엔티티의 no이기 때문에 int로 변수 지정
		int no = service.register(dto);
		
		System.out.println("새로운 게시물 번호: " + no);
		
	}
	
	@Test
	public void 게시물수정() {
		
		// 1) builder 이용
		BoardDTO dto = BoardDTO.builder()
								.no(11)
								.title("수정")
								.content("수정수정")
								.writer("수정자")
								.build();
		
		// 2) set 이용
			// 2-1) 게시물 조회
			BoardDTO dto2 = service.read(10);
			// 2-2) 일부 내용 변경
			dto2.setContent("수정 테스트");
			
		service.modify(dto);
		service.modify(dto2);
		
	}
	
	@Test
	public void 첫번째페이지_게시물목록조회() {
		
		// 첫 번째 페이지 조회
		Page<BoardDTO> page = service.getList(2); // 0 또는 1
		
		// 게시물 목록만 출력
		List<BoardDTO> list = page.getContent();
		
		for (BoardDTO dto : list) {
			System.out.println(dto);
		}
	}

}
