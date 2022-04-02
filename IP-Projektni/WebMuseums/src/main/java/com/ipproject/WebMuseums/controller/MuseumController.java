package com.ipproject.WebMuseums.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipproject.WebMuseums.dto.MuseumResponseDto;
import com.ipproject.WebMuseums.dto.MuseumWithVirtualToursDto;
import com.ipproject.WebMuseums.service.MuseumService;

@RestController
@RequestMapping("/museum")
public class MuseumController {
	
	@Autowired
	private MuseumService museumService;
	
	
	@GetMapping("/get-all")
	public List<MuseumResponseDto> getAll(){
		return museumService.getAll();
	}
	@GetMapping("")
	public MuseumWithVirtualToursDto getMuseum(@RequestParam("museumId") Integer museumId,@RequestParam("token")String userToken) {
		return museumService.getMuseumWithVirtualTours(museumId,userToken);
	}

}
