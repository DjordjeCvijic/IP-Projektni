package com.ipproject.WebMuseums.dto;

import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MuseumWithVirtualToursDto {

	
	private Integer museumId;
	private String name;
	private String address;
	private String phoneNumber;
	private String countryName;
	private String cityName;
	private String latitude;
	private String longitude;
	private String museumType;
	private List<VirtualTourResponseDto> virtualTourList=new LinkedList<>();
	
}
