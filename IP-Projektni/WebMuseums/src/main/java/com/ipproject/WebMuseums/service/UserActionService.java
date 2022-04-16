package com.ipproject.WebMuseums.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.ipproject.WebMuseums.model.UserAction;
import com.ipproject.WebMuseums.repository.UserActionRepository;

@Service
public class UserActionService {
	@Autowired
	private UserActionRepository userActionRepository;
	@Autowired
	private UserPersonService userPersonService;
	
	
	public void saveUserAction(String username,String action) {
		UserAction userAction=new UserAction();
		userAction.setAction(action);
		userAction.setTime(LocalDateTime.now());
		userAction.setUserPerson(userPersonService.getUserPersonByUsername(username).get());
		userActionRepository.save(userAction);
	}

}
