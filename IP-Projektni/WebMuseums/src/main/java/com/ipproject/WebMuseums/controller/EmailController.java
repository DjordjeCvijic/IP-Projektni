package com.ipproject.WebMuseums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipproject.WebMuseums.dto.EmailRequestDto;
import com.ipproject.WebMuseums.service.EmailSenderService;



@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailSenderService emailSenderService;
	
	
	
	@PostMapping("")
	public void sendEmail(@RequestBody EmailRequestDto emailRequestDto) {
		emailSenderService.sendSimpleEmail(emailRequestDto);
	}
}
