package com.example.demo.reposotory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Member;

public interface MemberReposotory extends JpaRepository<Member, String> {
	
	@Query(value = "SELECT * FROM tbl_member WHERE TBL_MEMBER.USER_ID LIKE :p1%", nativeQuery = true)
	List<Member> getQuiz81(@Param("p1") String id);
	
	@Query(value = "SELECT * FROM tbl_member WHERE TBL_MEMBER.GRADE = :p1", nativeQuery = true)
	List<Member> getQuiz82(@Param("p1") String grade);

}
