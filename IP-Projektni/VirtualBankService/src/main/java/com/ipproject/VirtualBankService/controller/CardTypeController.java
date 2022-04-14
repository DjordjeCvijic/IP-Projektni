package com.ipproject.VirtualBankService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipproject.VirtualBankService.CardTypeService;
import com.ipproject.VirtualBankService.model.CardType;

@RestController
@RequestMapping("/card-type")
public class CardTypeController {
	
	@Autowired
	private CardTypeService cardTypeService;
	
	@GetMapping("/get-all")
	public List<CardType> getAll(){
		return cardTypeService.getAllCardType();
	}
}
