package com.ipproject.WebMuseums.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VirtualTourTicketDto {
	
	private Integer userId;
	private Integer virtualTourId;

}
