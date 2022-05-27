package com.ipproject.WebMuseums.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ipproject.WebMuseums.dto.WeatherDataDto;

import springfox.documentation.spring.web.json.Json;

@Service
public class WeatherService {

	public WeatherDataDto getWeather(String latitude, String longitude) {
		WeatherDataDto result=new WeatherDataDto();
	
		 RestTemplate restTemplate = new RestTemplate();

	        String uri = "https://api.openweathermap.org/data/2.5/weather?lat="+latitude+"&lon="+longitude+"&appid=ed3d84b8e7ce847f0b29e51506488e63&units=metric"; 

	        HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

	        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
	        ResponseEntity<?> resultGet =
	                restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
	        
	        
	        System.out.println("nadam se da radi");
		System.out.println(resultGet.getBody().toString());
		
		try {
			JSONObject jsonObject= new JSONObject(resultGet.getBody().toString() );
			JSONArray weader=jsonObject.getJSONArray("weather");
			result.setDescription(weader.getJSONObject(0).getString("description"));
			JSONObject main=jsonObject.getJSONObject("main");
			
			result.setHumidity(main.getString("humidity"));
			result.setPressure(main.getString("pressure"));
			result.setTemperature(main.getString("temp"));
			
			result.setVisibility(jsonObject.getString("visibility"));
			result.setName(jsonObject.getString("name"));
			
			JSONObject wind=jsonObject.getJSONObject("wind");
			result.setWindSpeed(wind.getString("speed"));
			
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
