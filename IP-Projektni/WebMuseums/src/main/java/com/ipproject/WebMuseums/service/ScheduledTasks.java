package com.ipproject.WebMuseums.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ipproject.WebMuseums.dto.EmailRequestDto;
import com.ipproject.WebMuseums.model.VirtualTour;
import com.ipproject.WebMuseums.model.VirtualTourTicket;

@Component
public class ScheduledTasks {

	@Autowired
	VirtualTourService virtualTourService;
	@Autowired
	VirtualTourTicketService virtualTourTicketService;
	@Autowired
	EmailSenderService emailSenderService;
	
	@Scheduled(fixedRate = 60000)
	public void scheduleTaskWithFixedRate() {
	    System.out.println("Metoda za provjeru i obavjestavanje");
	    List<VirtualTour> virtualToursThatStartInOneHour=virtualTourService.getVirtualToursThatStartInOneHour();
	    for(VirtualTour virtualTour : virtualToursThatStartInOneHour) {
	    	List<VirtualTourTicket> ticketListForVirtualTour=virtualTourTicketService.getAllTicketForVirtualTour(virtualTour);
	    	EmailRequestDto emailRequest=new EmailRequestDto();
	    	ticketListForVirtualTour.forEach(virtualTourTicet->{
	    		emailRequest.setMailSubject(virtualTourTicet.getVirtualTour().getName());
	    		emailRequest.setMailBody("Virtual tour start in one hour.");
	    		emailRequest.setReceiverEmail(virtualTourTicet.getUserPerson().getEmail());
	    		emailSenderService.sendSimpleEmail(emailRequest);
	    	});
	    }
	    
	    
	    
	    List<VirtualTour> virtualToursThatEndInFiveMinutes=virtualTourService.getVirtualToursThatEndInFiveMinutes();
	    for(VirtualTour virtualTour : virtualToursThatEndInFiveMinutes) {
	    	List<VirtualTourTicket> ticketListForVirtualTour=virtualTourTicketService.getAllTicketForVirtualTour(virtualTour);
	    	EmailRequestDto emailRequest=new EmailRequestDto();
	    	ticketListForVirtualTour.forEach(virtualTourTicet->{
	    		emailRequest.setMailSubject(virtualTourTicet.getVirtualTour().getName());
	    		emailRequest.setMailBody("Virtual tour end in five minutes.");
	    		emailRequest.setReceiverEmail(virtualTourTicet.getUserPerson().getEmail());
	    		emailSenderService.sendSimpleEmail(emailRequest);
	    	});
	    }
	    
	}
}
