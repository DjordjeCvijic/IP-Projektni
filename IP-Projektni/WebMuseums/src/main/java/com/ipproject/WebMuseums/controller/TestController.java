package com.ipproject.WebMuseums.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;

@RestController
@RequestMapping("/test")
public class TestController {
	
	
	
	@GetMapping("")
	public TestDto  test()  {
		return new TestDto("123","napokon radi");
		//ResponseEntity<?>
		//return new ResponseEntity<String>("Pogrešni kredencijali!", HttpStatus.BAD_REQUEST);
	}

}
