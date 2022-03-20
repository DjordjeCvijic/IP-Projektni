package com.ipproject.WebMuseums.config;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ipproject.WebMuseums.model.AuthUserDetails;
import com.ipproject.WebMuseums.model.UserPerson;
import com.ipproject.WebMuseums.model.UserPersonRole;
import com.ipproject.WebMuseums.service.UserPersonRoleService;
import com.ipproject.WebMuseums.service.UserPersonService;


@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UserPersonService userPersonService;
	
	@Autowired
	UserPersonRoleService userPersonRoleService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserPerson> user = userPersonService.getUserPersonByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Nije pronađen korisnik sa username-om:" + username));
		List<UserPersonRole> userRoles = userPersonRoleService.findByUserPerson(user.get());

		return new AuthUserDetails(user, userRoles);
	}
	
	

}
