package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Students;

public interface StudentDao extends JpaRepository<Students, Long> {

}
