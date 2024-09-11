package com.example.demo.reposotory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Member;

public interface MemberReposotory extends JpaRepository<Member, String> {

}
