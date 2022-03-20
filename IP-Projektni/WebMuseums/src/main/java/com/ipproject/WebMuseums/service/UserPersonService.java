package com.ipproject.WebMuseums.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ipproject.WebMuseums.compositekey.UserPersonRoleKey;
import com.ipproject.WebMuseums.dto.UserPersonDto;
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

    public UserPerson saveUserPerson(UserPersonDto userPersonDto) {
        UserPerson user = userPersonRepository.save(buildUserFromDto(userPersonDto));
        
     Integer userRoleId=2;
            UserPersonRoleKey key = new UserPersonRoleKey(user.getUserPersonId(), userRoleId);//1 ce biti id od admina
            Role role = roleRepository.getById(userRoleId);
            userPersonRoleRepository.save(new UserPersonRole(key, user, role));
        


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
