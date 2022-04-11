package com.ipproject.VirtualBankService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipproject.VirtualBankService.model.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Integer>{

	Optional<BankAccount> findByCardNumber(String cardNumber);
}
