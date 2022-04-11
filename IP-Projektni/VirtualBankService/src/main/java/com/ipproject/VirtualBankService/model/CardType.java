package com.ipproject.VirtualBankService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "card_type")
public class CardType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cardTypeId;
	
	@Column(name = "card_type_name")
	private String cardTypeName;
	

}
