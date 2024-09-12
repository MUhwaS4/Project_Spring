package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tbl_member")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
	
	@Id
	@Column(length = 255, nullable = false)
	String user_id;
	
	@Column(length = 255, nullable = false)
	String grade;
	
	@Column(length = 255, nullable = false)
	String password;
	
	@CreatedDate // 데이터를 생성(추가)했을 때 딱 한 번 작성되는 날짜 데이터
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 날짜 포맷
	@Column(nullable = false)
	LocalDate registerDate;
	

}
