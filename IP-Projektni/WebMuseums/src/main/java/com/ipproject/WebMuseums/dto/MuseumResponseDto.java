package com.ipproject.WebMuseums.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.ipproject.WebMuseums.model.MuseumType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MuseumResponseDto {
	
	private Integer museumId;
	private String name;
	private String address;
	private String phoneNumber;
	private String countryName;
	private String cityName;
	private String latitude;
	private String longitude;
	private String museumType;

}
