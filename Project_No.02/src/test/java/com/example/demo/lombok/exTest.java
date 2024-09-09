package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class exTest {
	
	@Test
	void 북테스트() {
		Book book1 = new Book();
		book1.title = "가나다1";
		book1.price = 20000;
		book1.compuny = "출판사1";
		book1.page = 120;
		
		Book book2 = new Book("가나다2", 30000, "출판사2", 250);
		
		Book book3 = Book
						.builder()
						.title("가나다3")
						.price(30000)
						.compuny("출판사3")
						.page(200)
						.build();
		
		System.out.println(book1);
		System.out.println(book2);
		System.out.println(book3);
	}
	
	@Test
	void 롬복2() {
		
		Car car1 = new Car();
		car1.setModel("차종1");
		car1.setCompuny("회사1");
		car1.setColor("색상1");
		System.out.println(car1.getModel());
		System.out.println(car1.getCompuny());
		System.out.println(car1.getColor());
		
		Car car2 = new Car("차종2", "회사2", "색상2");
		
		Car car3 = Car
						.builder()
						.model("차종3")
						.compuny("회사3")
						.color("색상3")
						.build();
		
		System.out.println(car1);
		System.out.println(car2);
		System.out.println(car3);
		
	}
	
	@Test
	void 롬복3() {
		
		Student student1 = new Student();
		student1.setNumber(1);
		student1.setName("이름1");
		student1.setAge(17);
		System.out.println(student1.getNumber());
		System.out.println(student1.getName());
		System.out.println(student1.getAge());
		
		Student student2 = new Student(2, "이름2", 18);
		
		Student student3 = Student
						.builder()
						.number(3)
						.name("이름3")
						.Age(19)
						.build();
		
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3);
		
	}
	
	@Test
	void 롬복4() {
		
		Movie movie1 = new Movie();
		movie1.setTitle("영화제목1");
		movie1.setDirector("감독1");
		movie1.setDate("날짜1");
		System.out.println(movie1.getTitle());
		System.out.println(movie1.getDirector());
		System.out.println(movie1.getDate());
		
		Movie movie2 = new Movie("영화제목2", "감독2", "날짜2");
		
		Movie movie3 = Movie
						.builder()
						.title("영화제목3")
						.director("감독3")
						.date("날짜3")
						.build();
		
		System.out.println(movie1);
		System.out.println(movie2);
		System.out.println(movie3);
		
	}

}
