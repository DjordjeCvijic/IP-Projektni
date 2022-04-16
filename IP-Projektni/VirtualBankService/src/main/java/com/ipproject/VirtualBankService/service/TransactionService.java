package com.ipproject.VirtualBankService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ipproject.VirtualBankService.model.Transaction;
import com.ipproject.VirtualBankService.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	
	public void saveTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}

}
