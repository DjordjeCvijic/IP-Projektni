package com.ipproject.WebMuseums.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipproject.WebMuseums.dto.LoginCount;
import com.ipproject.WebMuseums.dto.UserInformationDto;
import com.ipproject.WebMuseums.service.LoginHistoryService;
import com.ipproject.WebMuseums.service.UserInfoService;
import com.ipproject.WebMuseums.service.UserPersonService;

@RestController
@RequestMapping("/user-info")
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private UserPersonService userPersonService;
	
	
	@GetMapping("")
	public UserInformationDto getLoginCounts(){
		return  userInfoService.getNumberOfLoginList();
	}
	@GetMapping("/change-password")
	public boolean changePassword(@RequestParam("userId")Integer userId) {
		return userPersonService.changePassword(userId);
	}
}
