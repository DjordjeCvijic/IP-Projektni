package com.ipproject.WebMuseums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipproject.WebMuseums.model.UserPerson;
import com.ipproject.WebMuseums.model.VirtualTour;
import com.ipproject.WebMuseums.model.VirtualTourTicket;

@Repository
public interface VirtualTourTicketRepository extends JpaRepository<VirtualTourTicket, Integer>{

	int countByTicketNumber(Long ticketNumber);
	int countByUserPersonAndVirtualTour(UserPerson userPerson,VirtualTour virtualTour);

}
