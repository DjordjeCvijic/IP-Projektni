package com.ipproject.VirtualBankService.service;



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
import com.ipproject.VirtualBankService.repository.BankAccountRepository;

@Service
public class BankAccountService {
	
	@Autowired
	private BankAccountRepository bankAccountRepository;

	public PaymentResponseDto payment(PaymentRequestDto paymentRequestDto) {

		try {
			BankAccount bankAccount=bankAccountRepository.findByCardNumber(paymentRequestDto.getCardNumber()).get();
			
			if(paymentRequestDto.getFirstName().equals(bankAccount.getFirstName()) &&
					paymentRequestDto.getLastName().equals(bankAccount.getLastName()) &&
					paymentRequestDto.getCardTypeId()==bankAccount.getCardType().getCardTypeId() &&
					paymentRequestDto.getExpirationDate().equals(bankAccount.getExpirationDate()) &&
					paymentRequestDto.getPin().doubleValue()==bankAccount.getPinNumber().doubleValue()
					) {
				if(bankAccount.getAccountBalance()-paymentRequestDto.getAmount()>=0) {
					
					sendData(paymentRequestDto);
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
