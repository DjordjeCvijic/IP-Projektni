package com.ipproject.WebMuseums.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipproject.WebMuseums.dto.MuseumResponseDto;
import com.ipproject.WebMuseums.model.Museum;
import com.ipproject.WebMuseums.repository.MuseumRepository;

@Service
public class MuseumService {

	
	@Autowired
	private MuseumRepository museumRepository;

	public List<MuseumResponseDto> getAll() {
		List<Museum> museumsFromStorage=museumRepository.findAll();
		List<MuseumResponseDto> resultList=new LinkedList<MuseumResponseDto>();
		museumsFromStorage.forEach(e->resultList.add(new MuseumResponseDto(e.getMuseumId(), e.getName(), e.getAddress(), e.getPhoneNumber(), e.getCountryName(), e.getCityName(), e.getLatitude(), e.getLongitude(), e.getMuseumType().getName())));
	
		return resultList;
	}
	public Museum getByMuseumId(Integer museumId) {
		return museumRepository.findByMuseumId(museumId).get();
	}
}
