package com.example.demo.reposotory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemoReporsitoryTest1_1 {
	
	@Autowired
	MemoReporsitory memoReporsitory;
	
	@Test
	public void 리파지토리객체를_가져왔는지확인() {
		System.out.println("memoRepository = " + memoReporsitory);
	}
	
	@Test
	public void 데이터등록() {
		
		// save: 테이블에 데이터를 추가하려는 함수
		memoReporsitory.save(null);
		
	}

}
