package com.ipproject.WebMuseums.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthenticationResponse {
	private String status;
	private String jwt;
}
