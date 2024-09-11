package com.example.demo.reposotory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Gift;

public interface GiftReposotory extends JpaRepository<Gift, Integer> {

}
