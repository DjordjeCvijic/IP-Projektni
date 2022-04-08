package com.ipproject.WebMuseums.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipproject.WebMuseums.model.UserStatus;
import com.ipproject.WebMuseums.repository.UserStatusRepository;

@Service
public class UserStatusService {
	
	@Autowired
	UserStatusRepository userStatusRepository;
	
	public UserStatus getUserStatusById(Integer userStatusId) {
		return userStatusRepository.findByUserStatusId(userStatusId).get();
	}

}
