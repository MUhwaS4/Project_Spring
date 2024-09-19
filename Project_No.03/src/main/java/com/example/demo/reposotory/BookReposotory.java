package com.example.demo.reposotory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Book;

public interface BookReposotory extends JpaRepository<Book, Integer> {
	
	// 메소드를 추가하는 방법
	// 쿼리메소드 @Query (jpql 문법, 순수한 spl)
	
	// Q5.
	
	@Query(value = "SELECT * FROM tbl_book WHERE TBL_BOOK.TITLE = :param", nativeQuery = true)
	List<Book> getQuiz51(@Param("param") String book);
	
	@Query(value = "SELECT * FROM tbl_book WHERE TBL_BOOK.PRICE > :p1  AND TBL_BOOK.PUBLISHER = :p2", nativeQuery = true)
	List<Book> getQuiz52(@Param("p1") int price, @Param("p2") String pub);
	
	@Query(value = "SELECT * FROM tbl_book WHERE TBL_BOOK.PUBLISHER = :p1 OR PUBLISHER = :p2", nativeQuery = true)
	List<Book> getQuiz53(@Param("p1") String pub1, @Param("p2") String pub2);
	
	// 1. SQL을 그대로 작성한다
	// 2. 변경될 수 있는 값(파라미터)을 매개변수로 선언한다
	// 예를 들어, 제목은 '자바~' 또는 '스프링~' 또는 '빈문자열'처럼 여러 가지가 될 수 있다
	// 이런 변수를 외부에서 입력받아 SQL에 동적으로 적용될 수 있도록 처리한다
	// 3. 파라미터로 전달된 값을 SQL에 바인딩한다
	@Query(value = "", nativeQuery = true)
	List<Book> get1();

}
