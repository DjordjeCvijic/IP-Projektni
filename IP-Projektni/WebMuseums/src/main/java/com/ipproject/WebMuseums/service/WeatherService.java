package com.ipproject.WebMuseums.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ipproject.WebMuseums.dto.WeatherDataDto;

@Service
public class WeatherService {
	
//	@Autowired
//	private final RestTemplate restTemplate;

	public WeatherDataDto getWeather(String latitude, String longitude) {
		WeatherDataDto result=new WeatherDataDto();
	
		
		 RestTemplate restTemplate = new RestTemplate();

	        String uri = "https://api.openweathermap.org/data/2.5/weather?lat=53.41667175&lon=-2.25000000&appid=ed3d84b8e7ce847f0b29e51506488e63&units=metric"; // or any other uri

	        HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

	        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
	        ResponseEntity<?> resultGet =
	                restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
	        System.out.println("nadam se da radi");
		System.out.println(resultGet.getBody().toString());
		
		
		
		return result;
	}

}
