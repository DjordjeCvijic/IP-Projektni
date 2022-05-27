package com.ipproject.WebMuseums.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipproject.WebMuseums.dto.VirtualTourRequestDto;
import com.ipproject.WebMuseums.dto.VirtualTourResponseDto;
import com.ipproject.WebMuseums.model.Museum;
import com.ipproject.WebMuseums.model.VirtualTour;
import com.ipproject.WebMuseums.model.VirtualTourTicket;
import com.ipproject.WebMuseums.repository.VirtualTourRepository;

@Service
public class VirtualTourService {
	
	@Autowired
	private VirtualTourRepository virtualTourRepository;
	@Autowired
	private MuseumService museumService;
	@Autowired
	private VirtualTourTicketService virtualTourTicketService;
	@Autowired
	private UserPersonService userPersonService;

	public List<VirtualTour> getAll() {
		return virtualTourRepository.findAll();
	}

	public VirtualTour add(VirtualTourRequestDto virtualTourRequestDto) {
		VirtualTour virtualTourToAdd=buildVirtualTourFromDto(virtualTourRequestDto);
		System.out.println(virtualTourToAdd.getMuseum().getMuseumId());
		return virtualTourRepository.save(virtualTourToAdd);
	}

	private VirtualTour buildVirtualTourFromDto(VirtualTourRequestDto virtualTourRequestDto) {
		VirtualTour virtualTour=new VirtualTour();
		virtualTour.setDuration(virtualTourRequestDto.getDuration());
		virtualTour.setMuseum(museumService.getByMuseumId(virtualTourRequestDto.getMuseumId()));
		virtualTour.setStartDateTime(virtualTourRequestDto.getStartDateTime());
		virtualTour.setYoutubeUrl(virtualTourRequestDto.getYoutubeUrl());
		return virtualTour;
	}

	public List<VirtualTour> getVirtualTourOfMuseum(Integer museumId) {
		
		return virtualTourRepository.findAllByMuseum(museumService.getByMuseumId(museumId));
	}
	public VirtualTour getVirtualTourById(Integer id) {
		return virtualTourRepository.findByVirtualTourId(id).get();
	}

	public List<VirtualTour> getVirtualToursThatStartInOneHour() {
		LocalDateTime currentDateTime=LocalDateTime.now();
		String string=currentDateTime.plusHours(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")); 
	    TemporalAccessor ta = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").parse(string);
	    LocalDateTime startOfTour = LocalDateTime.from(ta);

		List<VirtualTour>result=virtualTourRepository.findAllByStartDateTime(startOfTour);
		result.forEach(e->System.out.println("Pocinje za jedan sat:"+e.getName()));
		return result;
	}
	
	public List<VirtualTour> getVirtualToursThatEndInFiveMinutes() {
		List<VirtualTour>result=new LinkedList<>();
		List<VirtualTour>virtualToursThetStarted=virtualTourRepository.findAllByStartDateTimeBefore(LocalDateTime.now());
		
		
		LocalDateTime currentDateTime=LocalDateTime.now();
		String string=currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")); 
	    TemporalAccessor ta = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").parse(string);
	    LocalDateTime currentDateTimeWithNoSecond = LocalDateTime.from(ta);


		virtualToursThetStarted.forEach(e->{
			if(currentDateTimeWithNoSecond.equals(e.getStartDateTime().plusHours(e.getDuration()).minusMinutes(5))) {
				System.out.println("Zavrsava za 5 minuta "+e.getName());
				result.add(e);
			}
		});
		return result;
		
	}

	public List<VirtualTourResponseDto> getAllByUserId(Integer userId) {
		List<VirtualTourResponseDto> resultList=new LinkedList<>();
		List<VirtualTourTicket> virtualTourTicektOfUser=virtualTourTicketService.getAllByUser(userPersonService.getUserPersonById(userId));
		for(VirtualTourTicket ticket:virtualTourTicektOfUser) {
			if(ticket.getVirtualTour().getStartDateTime().plusHours(ticket.getVirtualTour().getDuration()).isAfter(LocalDateTime.now())) {//kraj im je poslije sadasnjeg vremena
				VirtualTourResponseDto virtualTourResponseDto=new VirtualTourResponseDto();
				virtualTourResponseDto.setDuration(ticket.getVirtualTour().getDuration());
				virtualTourResponseDto.setName(ticket.getVirtualTour().getName());
				virtualTourResponseDto.setPurchasedByUser(true);
				virtualTourResponseDto.setStartDateTime(ticket.getVirtualTour().getStartDateTime().format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy")));
				virtualTourResponseDto.setVirtualTourId(ticket.getVirtualTour().getVirtualTourId());
				virtualTourResponseDto.setYoutubeUrl(ticket.getVirtualTour().getYoutubeUrl());
				virtualTourResponseDto.setStarted(ticket.getVirtualTour().getStartDateTime().isBefore(LocalDateTime.now()));
				resultList.add(virtualTourResponseDto);
			}
		}

		
		return resultList;
	}
	
	
	

}
