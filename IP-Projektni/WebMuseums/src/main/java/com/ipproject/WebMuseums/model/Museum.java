package com.ipproject.WebMuseums.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="museum")
public class Museum {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer museumId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="country_name")
	private String countryName;
	
	@Column(name="city_name")
	private String cityName;
	
	@Column(name="latitude")
	private String latitude;
	
	@Column(name="longitude")
	private String longitude;
	
	@ManyToOne
	@MapsId("museumTypeId")
	@JoinColumn(name="museum_type_id",nullable=false)
	private MuseumType museumType;
	
	
	
}
