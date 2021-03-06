package com.ipproject.WebMuseums.model;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name="museum_type")
public class MuseumType {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer museumTypeId;
	
	@Column(name = "name")
	private String name;
	

}
