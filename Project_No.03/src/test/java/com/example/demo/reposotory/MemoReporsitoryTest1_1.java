package com.example.demo.reposotory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;

@SpringBootTest
public class MemoReporsitoryTest1_1 {
	
	// CRUD: 작성 Create, 읽기, Read, 업데이트(수정) Update, 삭제 Delete 테스트
	
	@Autowired
	MemoReporsitory memoReporsitory;
	
	@Test
	public void 리파지토리객체를_가져왔는지확인() {
		System.out.println("memoRepository = " + memoReporsitory);
	}
	
	@Test
	public void 데이터등록() {
		
		// 새로운 데이터 생성
		// no에 0(빈값)을 입력하면 auto increment로 자동생성됨
		// auto increment => no(int)의 경우 숫자를 순차대로 입력하지 않아도 게시글 순서에 맞춰 정해짐
		// 현재 Memo의 내용은 no(int)와 text(string/varchar)로 되어있기 때문에 해당 내용을 매개변수로 취급해서 작성
		
		// 여기서 사용한 롬복은 AllArgsConstructor지만, AllArgsConstructor은 입력할 수 있는 내용이 정해져 있기 때문에 Builder를 사용하는 것을 권장함 
//		Memo memo = new Memo(0, "새글입니다.");

		// Builder를 사용할 때의 예시
		// no(int)는 auto increment 처리되어있기 때문에 생략 가능, 외에도 입력값 선택이 자유로움
		// New 생성자 호출 생략 가능
		Memo memo = Memo
						.builder()
						.text("새글입니다.")
						.build();
		
		// save: 테이블에 데이터를 추가 또는 수정하는 함수
		// insert 또는 update sql이 생성됨
		memoReporsitory.save(memo);
		
	}
	
	@Test
	public void 데이터일괄등록() {
		
		// 메모 리스트 생성 (입력할 데이터를 모아놓음)
		List<Memo> list = new ArrayList<>();
		
		// 입력할 데이터 변수 작성
		Memo memo1 = Memo
				.builder()
				.text("새글입니다.")
				.build();
		
		Memo memo2 = Memo
				.builder()
				.build();
		
		// 리스트에 데이터 내용 추가
		list.add(memo1);
		list.add(memo2);
		
		// saveAll: 테이블에 데이터를 일괄적으로 추가 또는 수정하는 함수
		// 이때 인자값은 list를 입력
		memoReporsitory.saveAll(list);
		
	}
	
	@Test
	public void 데이터단건조회() {
		
		// 결과값을 반환받을 때는 함수의 선언부를 확인할 것
		// 그리고 그 타입을 대입연산자 앞부분에 변수로 선언
		// findById()의 경우 Optional<T>가 있음
		
		// findById: 단건 데이터를 조회하는 함수
		// Id = 해당 엔티티(Table)의 key(식별자=PK)
		// findById(n) = n은 찾고자 하는 데이터 PK의 데이터 값
		// 현재 Integer 타입이라고 되어있지만 엔티티에 설정된 PK 타입에 따라 변경될 수 있음
		Optional<Memo> optional = memoReporsitory.findById(5);
		
		// optional 객체 안에 값이 있는지 확인
		if(optional.isPresent() == true) {
			System.out.println(optional.get());
		} else {
			System.out.println("값이 없습니다.");
		}
		
		// find 함수를 이용하여 select sql이 생성됨
		
		// 과정: 
		// find 함수 호출
		// => JPA가 Sql을 자동으로 생성
		// => JDBC가 mariaDB로 SQL을 전달
		// => DB에서 데이터 조회
		// => 결과를 다시 받아옴
		
	}
	
	@Test
	public void 데이터수정() {
		
		// 입력할 데이터 변수 작성
		Memo memo = Memo
				.builder()
				.no(1) // 대상 PK
				.text("글이 수정되었습니다.") // 변경할 내용
				.build();
		
		// save: 데이터를 추가 또는 수정하는 함수
		memoReporsitory.save(memo);
		
		// select => update sql 생성		
		// 조회 결과에 따라 insert 또는 update가 수행됨
		// PK key값과 동일한 데이터가 없다면 생성, 있다면 수정
		
	}
	
	@Test
	public void 데이터삭제() {
		
		// deleteById: 특정 데이터를 삭제하는 함수
		// 여기서 deleteById(n)의 n은 찾고자 하는 데이터 PK의 데이터 값
		memoReporsitory.deleteById(1);
		
		// delete 함수를 실행하면 delete sql이 생성됨
		
	}
	
	@Test
	public void 데이터전체삭제() {
		
		// deleteAll: 테이블에 있는 모든 데이터를 일괄 삭제하는 함수, 매개변수 필요없음
		memoReporsitory.deleteAll();
		
		// select를 한 후 데이터 개수만큼 delete sql이 생성됨
		
	}

}
