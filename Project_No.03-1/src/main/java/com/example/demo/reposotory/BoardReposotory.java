package com.example.demo.reposotory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Board;

public interface BoardReposotory extends JpaRepository<Board, Integer>{
	
	// 부모한테 물려받은 CRUD 메소드가 있음
	// save findAll findBy ...

}
