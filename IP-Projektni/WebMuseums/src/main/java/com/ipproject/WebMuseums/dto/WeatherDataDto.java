package com.ipproject.WebMuseums.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDataDto {
	
	private String description;
	private String temperature;
	private String pressure;
	private String humidity;//vlaznost
	private String visibility;
	private String windSpeed;
	private String name;
}
