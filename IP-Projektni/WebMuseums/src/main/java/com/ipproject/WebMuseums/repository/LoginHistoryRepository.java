package com.ipproject.WebMuseums.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipproject.WebMuseums.model.LoginHistory;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Integer>{

	List<LoginHistory> findAllByLoggedTimeBetween(LocalDateTime start,LocalDateTime end);
}
