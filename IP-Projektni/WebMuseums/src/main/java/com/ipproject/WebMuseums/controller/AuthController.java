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
    UserPersonService userPersonService;
	
	
	 @PostMapping( "/login")
	    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
	            throws Exception {
		
	        try {
	            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
	           
	            SecurityContextHolder.getContext().setAuthentication(authentication);
	        } catch (BadCredentialsException ex) {
	            return new ResponseEntity<String>("Pogrešni kredencijali!", HttpStatus.BAD_REQUEST);
	        }

	        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
	        final String jwt = jwtUtil.generateToken(userDetails);

	        return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse(jwt), HttpStatus.OK);
	    }
	 
	 
	 @PostMapping("/registration")
	    public UserPersonResponseDto saveUserPerson(@RequestBody UserPersonDto requestBody) {
		
	        return userPersonService.saveUserPerson(requestBody);
	    }

}
