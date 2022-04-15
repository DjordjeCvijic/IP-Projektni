package com.ipproject.WebMuseums.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipproject.WebMuseums.dto.VirtualTourTicketDto;
import com.ipproject.WebMuseums.model.UserPerson;
import com.ipproject.WebMuseums.model.VirtualTour;
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
	@Autowired
	private EmailSenderService emailSenderService;

	public void addVirtualTourTicket(VirtualTourTicketDto virtualTourTicketDto) {
		VirtualTourTicket ticket=new VirtualTourTicket();
		
		Random random=new Random();
		Long ticketNumber=random.nextLong(100000);
		while(virtualTourTicketRepository.countByTicketNumber(ticketNumber)!=0) {
			ticketNumber=random.nextLong(100000);
		}
		ticket.setTicketNumber(ticketNumber);
		ticket.setUserPerson(userPersonService.getUserPersonById(virtualTourTicketDto.getUserId()));
		ticket.setVirtualTour(virtualTourService.getVirtualTourById(virtualTourTicketDto.getVirtualTourId()));
		
		
		VirtualTourTicket savedTicket=virtualTourTicketRepository.save(ticket);
		

		emailSenderService.sendEmailWithAttachment(savedTicket);
	}
	public boolean userBuyTicketForVirtualTour(Integer userId,Integer virtualTourId) {
		
		UserPerson user=userPersonService.getUserPersonById(userId);
		VirtualTour virtualTour=virtualTourService.getVirtualTourById(virtualTourId);
		return virtualTourTicketRepository.countByUserPersonAndVirtualTour(user, virtualTour)>0;
	
	}
	public List<VirtualTourTicket> getAllTicketForVirtualTour(VirtualTour virtualTour){
		return virtualTourTicketRepository.findAllByVirtualTour(virtualTour);
	}
	public List<VirtualTourTicket> getAllByUser(UserPerson userPerson){
		return virtualTourTicketRepository.findAllByUserPerson(userPerson);
	}
	
}
