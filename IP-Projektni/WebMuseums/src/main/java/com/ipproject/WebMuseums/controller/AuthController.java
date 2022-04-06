package com.ipproject.WebMuseums.controller;


import org.aspectj.weaver.SignatureUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipproject.WebMuseums.config.UserDetailsServiceImpl;
import com.ipproject.WebMuseums.dto.UserPersonDto;
import com.ipproject.WebMuseums.dto.UserPersonResponseDto;
import com.ipproject.WebMuseums.model.AuthenticationRequest;
import com.ipproject.WebMuseums.model.AuthenticationResponse;
import com.ipproject.WebMuseums.model.UserPerson;
import com.ipproject.WebMuseums.service.LoginHistoryService;
import com.ipproject.WebMuseums.service.UserPersonService;
import com.ipproject.WebMuseums.util.JwtUtil;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserPersonService userPersonService;
    @Autowired
    private LoginHistoryService loginHistoryService;
	
	
	 @PostMapping( "/login")
	    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
	            throws Exception {
		//1:uspijesno
		//2:pogresni kredencijali
	        try {
	            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
	           
	            SecurityContextHolder.getContext().setAuthentication(authentication);
	        } catch (BadCredentialsException ex) {

	        	return new AuthenticationResponse("2", ex.getMessage());
	        }
	        
	        
	        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
	        final String jwt = jwtUtil.generateToken(userDetails);
	        
	      //cuvanje tokena
	       userPersonService.saveToken(authenticationRequest.getUsername(),jwt);
	       //cuvanjen vremena logovanja(ako nema u trenutnom satu)
	       loginHistoryService.save(userPersonService.getUserPersonByUsername(authenticationRequest.getUsername()).get());
	        
	        return new AuthenticationResponse("1",jwt);

	    }
	 
	 
	 @PostMapping("/registration")
	    public UserPersonResponseDto saveUserPerson(@RequestBody UserPersonDto requestBody) {
		
	        return userPersonService.saveUserPerson(requestBody);
	    }
	 
	 @PostMapping("/log-out")
	 public void logout(@RequestBody String token) {
		userPersonService.logOutUser(token);
	 }
	 
	 

}
