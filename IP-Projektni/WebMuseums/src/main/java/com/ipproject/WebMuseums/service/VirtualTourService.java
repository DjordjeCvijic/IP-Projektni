package com.ipproject.WebMuseums.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipproject.WebMuseums.dto.VirtualTourRequestDto;
import com.ipproject.WebMuseums.model.Museum;
import com.ipproject.WebMuseums.model.VirtualTour;
import com.ipproject.WebMuseums.repository.VirtualTourRepository;

@Service
public class VirtualTourService {
	
	@Autowired
	private VirtualTourRepository virtualTourRepository;
	@Autowired
	private MuseumService museumService;

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
	
	
	

}
