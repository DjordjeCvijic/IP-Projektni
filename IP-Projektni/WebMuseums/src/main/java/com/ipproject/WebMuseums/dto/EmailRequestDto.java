package com.ipproject.WebMuseums.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequestDto {
	
	private String receiverEmail;
	private String mailBody;
	private String mailSubject;

}
