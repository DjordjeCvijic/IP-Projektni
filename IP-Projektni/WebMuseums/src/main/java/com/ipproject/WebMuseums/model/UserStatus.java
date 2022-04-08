package com.ipproject.WebMuseums.model;



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
@Table(name="user_status")
public class UserStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userStatusId;
	
	@Column(name = "user_status_name")
	private String userStatusName;

}
