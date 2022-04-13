package com.ipproject.VirtualBankService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDto {
	
	private String firstName;
	private String lastName;
	private String cardNumber;
	private Integer cardTypeId;
	private String expirationDate;
	private Integer pin;
	private Integer virtualTourId;
	private Integer userId;
	private Double amount;

}
