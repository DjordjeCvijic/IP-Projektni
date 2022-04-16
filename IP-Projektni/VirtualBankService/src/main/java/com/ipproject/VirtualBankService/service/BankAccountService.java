package com.ipproject.VirtualBankService.service;



import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ipproject.VirtualBankService.dto.PaymentRequestDto;
import com.ipproject.VirtualBankService.dto.PaymentResponseDto;
import com.ipproject.VirtualBankService.model.BankAccount;
import com.ipproject.VirtualBankService.model.Transaction;
import com.ipproject.VirtualBankService.repository.BankAccountRepository;

@Service
public class BankAccountService {
	
	@Autowired
	private BankAccountRepository bankAccountRepository;
	@Autowired
	private TransactionService transactionService;

	public PaymentResponseDto payment(PaymentRequestDto paymentRequestDto) {

		try {
			BankAccount bankAccount=bankAccountRepository.findByCardNumber(paymentRequestDto.getCardNumber()).get();
			
			if(paymentRequestDto.getFirstName().equals(bankAccount.getFirstName()) &&
					paymentRequestDto.getLastName().equals(bankAccount.getLastName()) &&
					paymentRequestDto.getCardTypeId()==bankAccount.getCardType().getCardTypeId() &&
					paymentRequestDto.getExpirationDate().equals(bankAccount.getExpirationDate()) &&
					paymentRequestDto.getPin().doubleValue()==bankAccount.getPinNumber().doubleValue()
					) {
				if(bankAccount.isActive()){
					if(bankAccount.getAccountBalance()-paymentRequestDto.getAmount()>=0) {
						
						sendData(paymentRequestDto);
						bankAccount.setAccountBalance(bankAccount.getAccountBalance()-paymentRequestDto.getAmount());
						BankAccount savedBankAccount= bankAccountRepository.save(bankAccount);
						Transaction transaction=new Transaction();
						transaction.setAmount(paymentRequestDto.getAmount());
						transaction.setBankAccount(savedBankAccount);
						transaction.setTime(LocalDateTime.now());
						transactionService.saveTransaction(transaction);
						return new PaymentResponseDto(1,"Payment successful");
						
						
					}else {
						return new PaymentResponseDto(2,"You don't have enough money in your account");
					}
					
				}else {
					return new PaymentResponseDto(2,"Your bank account is blocked");
				}
				
				
			}else {
				return new PaymentResponseDto(2,"Data are incorrect!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new PaymentResponseDto(2,"Data are incorrect!");
		}
		
	}

	private void sendData(PaymentRequestDto paymentRequestDto) {
		RestTemplate restTemplate=new RestTemplate();
		String url = "http://localhost:1123/virtual-tour-ticket/buy-ticket";
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);

	    
	    Map<String, Object> map = new HashMap<>();
	    map.put("userId", paymentRequestDto.getUserId());
	    map.put("virtualTourId", paymentRequestDto.getVirtualTourId());
	    
	    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
	    
	    restTemplate.postForLocation(url, entity);


		 
	}

}
