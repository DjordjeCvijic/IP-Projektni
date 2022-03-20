package com.ipproject.WebMuseums.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipproject.WebMuseums.model.UserPerson;
import com.ipproject.WebMuseums.model.UserPersonRole;
import com.ipproject.WebMuseums.repository.UserPersonRoleRepository;

@Service
public class UserPersonRoleService {

	@Autowired 
	UserPersonRoleRepository userPersonRoleRepository;

	public List<UserPersonRole> findByUserPerson(UserPerson userPerson) {
		return userPersonRoleRepository.findByUserPerson(userPerson);
	}
}
