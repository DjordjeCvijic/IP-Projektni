package com.ipproject.WebMuseums.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipproject.WebMuseums.dto.VirtualTourRequestDto;
import com.ipproject.WebMuseums.dto.VirtualTourResponseDto;
import com.ipproject.WebMuseums.model.VirtualTour;
import com.ipproject.WebMuseums.service.VirtualTourService;



@RestController
@RequestMapping("/virtual-tour")
public class VirtualTourController {
	
	@Autowired
	private VirtualTourService virtualTourService;
	
	
	@GetMapping("")
	public List<VirtualTour> getAll(){
		return virtualTourService.getAll();
	}
	

	
	@GetMapping("/get-by-user")
	public List<VirtualTourResponseDto>getAllByUser(@RequestParam("userId")Integer userId){
		return virtualTourService.getAllByUserId(userId);
	}

}
