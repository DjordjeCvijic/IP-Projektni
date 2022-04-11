package com.ipproject.VirtualBankService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipproject.VirtualBankService.dto.PaymentRequestDto;
import com.ipproject.VirtualBankService.dto.PaymentResponseDto;
import com.ipproject.VirtualBankService.model.BankAccount;
import com.ipproject.VirtualBankService.repository.BankAccountRepository;

@Service
public class BankAccountService {
	
	@Autowired
	private BankAccountRepository bankAccountRepository;

	public PaymentResponseDto payment(PaymentRequestDto paymentRequestDto) {

		try {
			BankAccount bankAccount=bankAccountRepository.findByCardNumber(paymentRequestDto.getCardNumber()).get();
			System.out.println(paymentRequestDto.getPin()+"    "+bankAccount.getPinNumber());
			if(paymentRequestDto.getFirstName().equals(bankAccount.getFirstName()) &&
					paymentRequestDto.getLastName().equals(bankAccount.getLastName()) &&
					paymentRequestDto.getCardTypeId()==bankAccount.getCardType().getCardTypeId() &&
					paymentRequestDto.getExpirationDate().equals(bankAccount.getExpirationDate()) &&
					paymentRequestDto.getPin().doubleValue()==bankAccount.getPinNumber().doubleValue()
					) {
				if(bankAccount.getAccountBalance()-paymentRequestDto.getAmount()>=0) {
					return new PaymentResponseDto(1,"Uplata uspijesna");
					//ovdje treba updatovati racun sa smanjenim iznosom
				}else {
					return new PaymentResponseDto(2,"Nema dovoljno na racunu");
				}
				
			}else {
				return new PaymentResponseDto(2,"Podaci nisu validni");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new PaymentResponseDto(2,"Podaci nisssssssss validni");
		}
		
	}

}
