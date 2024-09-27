package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass // JPA가 엔티티 스캔 시 생략
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
public class BaseEntity {
	
	@CreatedDate // insert 시 현재 시간을 저장
	LocalDateTime regDate; // 등록일
	
	@LastModifiedDate // update 시 현재 시간을 저장 
	LocalDateTime modDate; // 수정일

}
