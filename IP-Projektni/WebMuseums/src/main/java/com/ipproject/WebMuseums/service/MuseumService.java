package com.ipproject.WebMuseums.service;

import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipproject.WebMuseums.dto.MuseumResponseDto;
import com.ipproject.WebMuseums.dto.MuseumWithVirtualToursDto;
import com.ipproject.WebMuseums.dto.VirtualTourResponseDto;
import com.ipproject.WebMuseums.model.Museum;
import com.ipproject.WebMuseums.model.VirtualTour;
import com.ipproject.WebMuseums.repository.MuseumRepository;

@Service
public class MuseumService {

	
	@Autowired
	private MuseumRepository museumRepository;
	@Autowired
	private VirtualTourService virtualTourService;
	@Autowired
	private WeatherService weatherService;

	public List<MuseumResponseDto> getAll() {
		List<Museum> museumsFromStorage=museumRepository.findAll();
		List<MuseumResponseDto> resultList=new LinkedList<MuseumResponseDto>();
		museumsFromStorage.forEach(e->resultList.add(new MuseumResponseDto(e.getMuseumId(), e.getName(), e.getAddress(), e.getPhoneNumber(), e.getCountryName(), e.getCityName(), e.getLatitude(), e.getLongitude(), e.getMuseumType().getName())));

		//dodato
		weatherService.getWeather("", "");
		//
		return resultList;
	}
	public Museum getByMuseumId(Integer museumId) {
		return museumRepository.findByMuseumId(museumId).get();
	}
	public MuseumWithVirtualToursDto getMuseumWithVirtualTours(Integer museumId, String userToken) {
		MuseumWithVirtualToursDto result=new MuseumWithVirtualToursDto();
		
		Museum museum=museumRepository.findByMuseumId(museumId).get();
		result.setAddress(museum.getAddress());
		result.setCityName(museum.getCityName());
		result.setCountryName(museum.getCountryName());
		result.setLatitude(museum.getLatitude());
		result.setLongitude(museum.getLongitude());
		result.setMuseumId(museumId);
		result.setMuseumType(museum.getMuseumType().getName());
		result.setName(museum.getName());
		result.setPhoneNumber(museum.getPhoneNumber());
		List<VirtualTour>virtualTourList=virtualTourService.getVirtualTourOfMuseum(museumId);
		virtualTourList.forEach(element->{
			VirtualTourResponseDto virtualTourResponseDto=new VirtualTourResponseDto();
			virtualTourResponseDto.setName(element.getName());
			virtualTourResponseDto.setDuration(element.getDuration());
			virtualTourResponseDto.setPurchasedByUser(false);//oov treba implementirati
			virtualTourResponseDto.setStartDateTime(element.getStartDateTime().format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy")));
			virtualTourResponseDto.setVirtualTourId(element.getVirtualTourId());
			virtualTourResponseDto.setYoutubeUrl(element.getYoutubeUrl());
			
			result.getVirtualTourList().add(virtualTourResponseDto);
		});
		
		result.setWeather(weatherService.getWeather(museum.getLatitude(),museum.getLongitude()));
		
		
		return result;
	}
}
