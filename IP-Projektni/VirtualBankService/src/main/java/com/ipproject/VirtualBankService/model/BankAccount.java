package com.ipproject.VirtualBankService.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "bank_account")
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bankAccountId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "card_number", unique = true)
	private String cardNumber;
	
	@Column(name = "expiration_date")
	private String expirationDate;
	
	@Column(name = "pin_number", unique = true)
	private Integer pinNumber;
	
	@Column(name = "account_balance")
	private Double accountBalance;
	
	@ManyToOne
	@JoinColumn(name = "card_type_id",nullable = false)
	private CardType cardType;

}
