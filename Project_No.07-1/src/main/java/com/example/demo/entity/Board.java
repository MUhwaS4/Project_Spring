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
@Table(name="tbl_dx3") // 테이블 이름 설정
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int no; // 캐릭터 번호
	
	@Column(length = 100, nullable = false)
	String name; // 이름
	
	@Column(length = 150, nullable = false)
	String codename; // 코드네임
	
	@Column(length = 200, nullable = false)
	String syndrome; // 신드롬
	
	@Column(length = 50, nullable = false)
	String work; // 웍스
	
	@Column(length = 100, nullable = false)
	String dLois;

}
