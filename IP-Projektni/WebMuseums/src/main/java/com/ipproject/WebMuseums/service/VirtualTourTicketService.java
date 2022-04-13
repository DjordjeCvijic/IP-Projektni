package com.ipproject.WebMuseums.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipproject.WebMuseums.dto.VirtualTourTicketDto;
import com.ipproject.WebMuseums.model.VirtualTourTicket;
import com.ipproject.WebMuseums.repository.VirtualTourTicketRepository;

@Service
public class VirtualTourTicketService {

	@Autowired
	private VirtualTourTicketRepository virtualTourTicketRepository;
	@Autowired
	private UserPersonService userPersonService;
	@Autowired
	private VirtualTourService virtualTourService;

	public void addVirtualTourTicket(VirtualTourTicketDto virtualTourTicketDto) {
		System.out.println(virtualTourTicketDto.getUserId()+"  "+virtualTourTicketDto.getVirtualTourId());
		VirtualTourTicket ticket=new VirtualTourTicket();
		
		Random random=new Random();
		Long ticketNumber=random.nextLong(100000);
		while(virtualTourTicketRepository.countByTicketNumber(ticketNumber)!=0) {
			ticketNumber=random.nextLong(100000);
		}
		ticket.setTicketNumber(ticketNumber);
		ticket.setUserPerson(userPersonService.getUserPersonById(virtualTourTicketDto.getUserId()));
		ticket.setVirtualTour(virtualTourService.getVirtualTourById(virtualTourTicketDto.getVirtualTourId()));
		
		
		virtualTourTicketRepository.save(ticket);
		
				
		
	}
}