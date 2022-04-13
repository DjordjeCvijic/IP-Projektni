package com.ipproject.WebMuseums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipproject.WebMuseums.dto.VirtualTourTicketDto;
import com.ipproject.WebMuseums.service.VirtualTourTicketService;

@RestController
@RequestMapping("/virtual-tour-ticket")
public class VirtualTourTicketController {
	
	@Autowired
	private VirtualTourTicketService virtualTourTicketService;
	
	
	
	@PostMapping("/buy-ticket")
	public void buyTicket(@RequestBody VirtualTourTicketDto virtualTourTicketDto) {
		virtualTourTicketService.addVirtualTourTicket(virtualTourTicketDto);
		
	}

}
