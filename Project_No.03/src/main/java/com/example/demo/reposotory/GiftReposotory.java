package com.example.demo.reposotory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Gift;

public interface GiftReposotory extends JpaRepository<Gift, Integer> {
	
	@Query(value = "SELECT * FROM tbl_gift WHERE TBL_GIFT.PRICE >= :p1", nativeQuery = true)
	List<Gift> getQuiz61(@Param("p1") int pri);
	
	@Query(value = "SELECT * FROM tbl_gift WHERE TBL_GIFT.NAME LIKE :p1", nativeQuery = true)
	List<Gift> getQuiz62(@Param("p1") String lastName);
	
	@Query(value = "SELECT * FROM tbl_gift WHERE TBL_GIFT.PRICE <= :p1 AND TBL_GIFT.TYPE = :p2", nativeQuery = true)
	List<Gift> getQuiz63(@Param("p1") int pri, @Param("p2") String type);

}
