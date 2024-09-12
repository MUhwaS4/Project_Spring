package com.example.demo.reposotory;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;

@SpringBootTest
public class MemoReporsitoryTest3 {
	
	@Autowired
	MemoReporsitory2 memoReporsitory;
	
	@Test
	public void 번호가3보다작은_메모검색() {
		
		List<Memo> list = memoReporsitory.get1(3);
		
		for (Memo memo : list) {
			System.out.println(memo);
		}
		
	}
	
	@Test
	public void 내용이없는_메모검색() {
		List<Memo> list = memoReporsitory.get2();
		
		for (Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 번호가10과20사이인_메모검색() {
		List<Memo> list = memoReporsitory.get3(10, 20);
				
		for (Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 번호를기준으로역정렬한_메모검색() {
		List<Memo> list = memoReporsitory.get4(); // 조회 후 리스트 반환
		
		for (Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 데이터삭제() {
		memoReporsitory.delete1(15); // PK(NO)
	}
	
	@Test
	public void 데이터수정() {
		// 조회
		Optional<Memo> result = memoReporsitory.findById(15);
		Memo memo = result.get();
		
		// 일부 변경
		memo.setText("변경했습니다~.");
		
		// 수정
		memoReporsitory.update1(memo);
	}
	

}
