package com.ipproject.WebMuseums.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipproject.WebMuseums.dto.LoginCount;
import com.ipproject.WebMuseums.dto.UserInformationDto;
import com.ipproject.WebMuseums.service.LoginHistoryService;
import com.ipproject.WebMuseums.service.UserInfoService;

@RestController
@RequestMapping("/user-info")
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	
	
	@GetMapping("")
	public UserInformationDto getLoginCounts(){
		return  userInfoService.getNumberOfLoginList();
	}
}
