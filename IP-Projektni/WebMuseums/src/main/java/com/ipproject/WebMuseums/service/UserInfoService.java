package com.ipproject.WebMuseums.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ipproject.WebMuseums.dto.UserInformationDto;

@Service
public class UserInfoService {
	@Autowired
	private LoginHistoryService loginHistoryService;
	@Autowired
	private UserPersonService userPersonService;

	public UserInformationDto getNumberOfLoginList() {
		UserInformationDto result=new UserInformationDto();
		result.setLoginCountList(loginHistoryService.getNumberOfLoginList());
		result.setActiveUsersCount(userPersonService.getActiveUsersCount());
		result.setRegisteredUsersCount(userPersonService.getRegisteredUsersCount());
		
		return result;
	}

}
