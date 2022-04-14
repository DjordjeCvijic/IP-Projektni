package com.ipproject.VirtualBankService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipproject.VirtualBankService.model.CardType;

@Repository
public interface CardTypeRepository extends JpaRepository<CardType, Integer>{
	
}
