package com.example.demo.reposotory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;

@SpringBootTest
public class OrderReposotoryTest {
	
	@Autowired
	OrderReposotory orderReposotory;
	
	@Test
	public void 객체확인() {
		System.out.println(orderReposotory);
	}
	
	@Test
	public void 데이터조회() {
		Optional<Order> result = orderReposotory.findById(1);
		if (result.isPresent()) {
			Order order = result.get();
			System.out.println(order);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		List<Order> list = orderReposotory.findAll();
		for (Order order : list) {
			System.out.println(order);
		}
	}
	
	@Test
	public void 데이터추가() {
		List<Order> list = new ArrayList<>();
		
		LocalDate localDate1 = LocalDate.of(2023, 7, 1);
		LocalDate localDate2 = LocalDate.of(2023, 7, 2);
		LocalDate localDate3 = LocalDate.of(2023, 7, 3);
		
		Order order1 = new Order(0, "둘리", localDate1, "인천 구월동");
		Order order2 = new Order(0, "또치", localDate2, "인천 연수동");
		Order order3 = new Order(0, "도우너", localDate3, "부산 동래동");
		Order order4 = new Order(0, "마이콜", localDate1, null);
		Order order5 = new Order(0, "고길동", localDate2, null);
		
		list.add(order1);
		list.add(order2);
		list.add(order3);
		list.add(order4);
		list.add(order5);
		
		orderReposotory.saveAll(list);
	}
	
	@Test
	public void 데이터수정() {
		Optional<Order> optional = orderReposotory.findById(1);
		Order order = optional.get();
		order.setCustomerName("이름 수정");
		
		orderReposotory.save(order);
	}
	
	@Test
	public void 데이터삭제() {
		orderReposotory.deleteById(2);
	}

}
