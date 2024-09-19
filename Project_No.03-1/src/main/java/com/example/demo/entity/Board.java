package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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

// 엔티티에 변화를 감지하는 리스너 설정
@EntityListeners(AuditingEntityListener.class)
@Entity // jpa에서 관리하는 엔티티 표시
@Table(name = "tbl_board") // 테이블 이름 생략 가능
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
	
	@Id // PK + AUTO INCREAMENT
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int boardNo; // 게시물 번호
	
	// 컬럼의 정보 설정 (크기, NOT NULL 옵션)
	@Column(length = 30, nullable = false) // NULL X
	String title; // 제목
	
	@Column(length = 200) // NULL OK
	String content; // 내용
	
	@CreatedDate // INSERT 시 실행
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime createdDate; // 등록일
	
	@LastModifiedDate // INSERT 및 UPDATE 시 실행
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime modifiedDate; // 수정일
	
	// 시스템 입력: 게시물 번호, 등록일, 수정일
	// 사용자 입력: 제목, 내용

}
