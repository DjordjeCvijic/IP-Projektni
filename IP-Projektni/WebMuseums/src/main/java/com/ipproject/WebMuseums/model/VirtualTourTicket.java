package com.ipproject.WebMuseums.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "virtual_tour_ticket")
public class VirtualTourTicket {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	private Integer virtualTourTicketId;
	
	@Column(name="ticket_number", unique = true)
	private Long ticketNumber;
	
	@ManyToOne
	@JoinColumn(name = "user_person_id",nullable = false)
	private UserPerson userPerson;
	
	@ManyToOne
	@JoinColumn(name="virtual_tour_id",nullable = false)
	private VirtualTour virtualTour;
	
	

}
