package com.ipproject.VirtualBankService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipproject.VirtualBankService.model.CardType;
import com.ipproject.VirtualBankService.repository.CardTypeRepository;

@Service
public class CardTypeService {
	@Autowired
	private CardTypeRepository cardTypeRepository;
	
	
	public List<CardType>getAllCardType(){
		return  cardTypeRepository.findAll();
	}
	

}
