package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tbl_board") // 실제 테이블 이름
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int no; // 글 번호
	
	@Column(length = 100, nullable = false)
	String title; // 제목
	
	@Column(length = 1500, nullable = false)
	String content; // 내용
	
	@Column(length = 50, nullable = false)
	String writer; // 작성자
	
	// 이후 entity 생성 방법
	// 1) 어플리케이션 실행
	// 2) SpringBootTest가 있는 단위 테스트 실행

}
