package com.example.demo.reposotory;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Order;

public interface OrderReposotory extends JpaRepository<Order, Integer>{
	
	@Query(value = "SELECT * FROM tbl_order WHERE TBL_ORDER.SHIP_ADDRESS LIKE %:p1%", nativeQuery = true)
	List<Order> getQuiz71(@Param("p1") String address);
	
	@Query(value = "SELECT * FROM tbl_order WHERE TBL_ORDER.CREATED_DATE = :p1", nativeQuery = true)
	List<Order> getQuiz72(@Param("p1") LocalDate date);

}
