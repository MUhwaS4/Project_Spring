package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDTO {
	
	int no;
	String name;
	String codename;
	String syndrome;
	String work;
	String drois;
	LocalDateTime regDate; // 등록일
	LocalDateTime modDate; // 수정일

}
