package com.ipproject.VirtualBankService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipproject.VirtualBankService.dto.PaymentRequestDto;
import com.ipproject.VirtualBankService.dto.PaymentResponseDto;
import com.ipproject.VirtualBankService.service.BankAccountService;

@RestController
@RequestMapping("/payment")
public class VirtualBankController {
	
	@Autowired
	private BankAccountService bankAccountService;
	
	
	@PostMapping("")
	public PaymentResponseDto payment(@RequestBody PaymentRequestDto paymentRequestDto) {
		return bankAccountService.payment(paymentRequestDto);
		
	}

}
