package com.ipproject.WebMuseums.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipproject.WebMuseums.dto.LoginCount;
import com.ipproject.WebMuseums.service.LoginHistoryService;

@RestController
@RequestMapping("/login-history")
public class LoginHistoryController {
	@Autowired
	private LoginHistoryService loginHistoryService;
	
	
	@GetMapping("")
	public List<LoginCount> getLoginCounts(){
		return loginHistoryService.getNumberOfLoginList();
	}
}
