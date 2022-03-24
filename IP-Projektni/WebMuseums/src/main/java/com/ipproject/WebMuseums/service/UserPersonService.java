package com.ipproject.WebMuseums.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ipproject.WebMuseums.compositekey.UserPersonRoleKey;
import com.ipproject.WebMuseums.dto.UserPersonDto;
import com.ipproject.WebMuseums.dto.UserPersonResponseDto;
import com.ipproject.WebMuseums.model.Role;
import com.ipproject.WebMuseums.model.UserPerson;
import com.ipproject.WebMuseums.model.UserPersonRole;
import com.ipproject.WebMuseums.repository.RoleRepository;
import com.ipproject.WebMuseums.repository.UserPersonRepository;
import com.ipproject.WebMuseums.repository.UserPersonRoleRepository;

@Service
public class UserPersonService {
	
	@Autowired
	UserPersonRepository userPersonRepository;
	@Autowired
    PasswordEncoder passwordEncoder;
	 @Autowired
	    RoleRepository roleRepository;
	 @Autowired
	    UserPersonRoleRepository userPersonRoleRepository;

	public Optional<UserPerson> getUserPersonByUsername(String username) {
		return userPersonRepository.findByUsername(username);
	}

    public UserPersonResponseDto saveUserPerson(UserPersonDto userPersonDto) {
    	if(userPersonRepository.countByUsername(userPersonDto.getUsername())!=0) {
    		return new UserPersonResponseDto("2");
    	}
    	if(userPersonRepository.countByEmail(userPersonDto.getEmail())!=0) {
    		return new UserPersonResponseDto("3");
    	}
        UserPerson savedUser = userPersonRepository.save(buildUserFromDto(userPersonDto));
        Integer userRoleId=2;//registrovati se mogu samo obicni korisnici
        UserPersonRoleKey key = new UserPersonRoleKey(savedUser.getUserPersonId(), userRoleId);
        Role role = roleRepository.getById(userRoleId);
        userPersonRoleRepository.save(new UserPersonRole(key, savedUser, role));
        
        return buildUserToReply(savedUser);
        
    }

	private UserPersonResponseDto buildUserToReply(UserPerson savedUser) {
		UserPersonResponseDto user=new UserPersonResponseDto();
		user.setStatus("1");
		user.setActive(true);
		user.setEmail(savedUser.getEmail());
		user.setFirstName(savedUser.getEmail());
		user.setLastName(savedUser.getLastName());
		user.setPassword(savedUser.getPassword());
		user.setUsername(savedUser.getUsername());
		user.setUserPersonId(savedUser.getUserPersonId());
		return user;
	}

	private UserPerson buildUserFromDto(UserPersonDto userPersonDto) {
		UserPerson userPerson = new UserPerson();
//        if (userPersonDto.getUserPersonId() != null)
//            userPerson.setUserPersonId(userPersonDto.getUserPersonId());

        userPerson.setFirstName(userPersonDto.getFirstName());
        userPerson.setLastName(userPersonDto.getLastName());
        userPerson.setUsername(userPersonDto.getUsername());
        userPerson.setPassword(passwordEncoder.encode(userPersonDto.getPassword()));
        userPerson.setEmail(userPersonDto.getEmail());

        return userPerson;
	}
	
	

}
