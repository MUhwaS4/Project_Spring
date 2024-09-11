package com.example.demo.reposotory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Gift;

@SpringBootTest
public class GiftReposotoryTest {
	
	@Autowired
	GiftReposotory giftReposotory;
	
	@Test
	public void 객체확인() {
		System.out.println("giftReposotory: " + giftReposotory);
	}
	
	@Test
	public void 데이터조회() {
		Optional<Gift> result = giftReposotory.findById(1);
		
		if (result.isPresent()) {
			Gift gift = result.get();
			System.out.println(gift);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		List<Gift> list = giftReposotory.findAll();
		for (Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void 데이터추가() {
		List<Gift> list = new ArrayList<>();
		
		Gift gift1 = Gift
						.builder()
						.name("참치세트")
						.price(10000)
						.type("식품")
						.build();
		list.add(gift1);
		
		Gift gift2 = Gift
						.builder()
						.name("햄세트")
						.price(20000)
						.type("식품")
						.build();
		list.add(gift2);
		
		Gift gift3 = Gift
						.builder()
						.name("샴푸세트")
						.price(20000)
						.type("생활용품")
						.build();
		list.add(gift3);
		
		Gift gift4 = Gift
						.builder()
						.name("세차용품")
						.price(40000)
						.type("생활용품")
						.build();
		list.add(gift4);
		
		Gift gift5 = Gift
						.builder()
						.name("주방용품")
						.price(50000)
						.type("생활용품")
						.build();
		list.add(gift5);
		
		Gift gift6 = Gift
						.builder()
						.name("노트북")
						.price(20000)
						.type("가전제품")
						.build();
		list.add(gift6);
		
		Gift gift7 = Gift
						.builder()
						.name("벽걸이TV")
						.price(20000)
						.type("가전제품")
						.build();
		list.add(gift7);
						
		giftReposotory.saveAll(list);
	}
	
	@Test
	public void 데이터수정() {
		Optional<Gift> result = giftReposotory.findById(1);
		Gift gift = result.get();
		gift.setName("이름수정");
		
		giftReposotory.save(gift);
	}
	
	@Test
	public void 데이터삭제() {
		giftReposotory.deleteById(2);
	}

}
