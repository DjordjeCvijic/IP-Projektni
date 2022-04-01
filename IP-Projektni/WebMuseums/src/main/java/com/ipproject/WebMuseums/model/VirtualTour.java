package com.ipproject.WebMuseums.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "virtual_tour")
public class VirtualTour {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer virtualTourId;
	
	@Column(name = "start_date_time")
	private LocalDateTime startDateTime;
	
	@Column(name = "duration")
	private Integer duration;
	
	@Column(name="youtube_url")
	private String youtubeUrl;
	
	@ManyToOne
	@MapsId("museumId")
	@JoinColumn(name="museum_id", nullable = false)
	private Museum museum;
	
	

	

}
