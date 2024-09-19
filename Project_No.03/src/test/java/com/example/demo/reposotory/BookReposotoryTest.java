package com.example.demo.reposotory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;

@SpringBootTest
public class BookReposotoryTest {
	
	@Autowired
	BookReposotory bookReposotory;
	
	@Test
	public void 객체확인() {
		
		System.out.println("bookReposotory" + bookReposotory);
		
	}
	
	@Test
	public void 데이터조회() {
		
		Optional<Book> result = bookReposotory.findById(1);
		
		if (result.isPresent()) {
			Book book = result.get();
			System.out.println(book);
		}
		
	}
	
	@Test
	public void 데이터전체조회() {
		
		List<Book> list = bookReposotory.findAll();
		
		for (Book book : list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void 데이터추가() {
		
		List<Book> list = new ArrayList<>();
		
		Book book1 = Book
						.builder()
						.price(20000)
						.publisher("한빛출판사")
						.title("자바프로그래밍입문")
						.build();
		
		Book book2 = Book
						.builder()
						.price(25000)
						.publisher("남가람북스")
						.title("스프링부트프로젝트")
						.build();
		
		Book book3 = Book
						.builder()
						.price(40000)
						.publisher("남가람북스")
						.title("실무로 끝내는 PHP")
						.build();
		
		Book book4 = Book
						.builder()
						.price(35000)
						.publisher("이지스퍼블리싱")
						.title("알고리즘코딩테스트")
						.build();
		
		list.add(book1);
		list.add(book2);
		list.add(book3);
		list.add(book4);
		
		bookReposotory.saveAll(list);
	}
	
	@Test
	public void 데이터수정() {
		
		Optional<Book> result = bookReposotory.findById(1);
		Book book = result.get();
		book.setTitle("제목수정");
		book.setPublisher("내용수정");
		
		bookReposotory.save(book);
		
	}
	
	@Test
	public void 데이터삭제() {
		
		bookReposotory.deleteById(2);
		
	}
	
	// Q5.
	
	@Test
	public void Q5제목검색() {
		List<Book> list = bookReposotory.getQuiz51("자바프로그래밍입문");
		
		for (Book book : list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void Q5가격출판사검색() {
		List<Book> list = bookReposotory.getQuiz52(30000,"남가람북스");
		
		for (Book book : list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void Q5출판사or검색() {
		List<Book> list = bookReposotory.getQuiz53("한빛출판사","이지스퍼블리싱");
		
		for (Book book : list) {
			System.out.println(book);
		}
	}

}
