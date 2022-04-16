package com.ipproject.WebMuseums.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="user_action")
public class UserAction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userActionId;
	
	@ManyToOne
	@JoinColumn(name="user_person_id",nullable = false)
	private UserPerson userPerson;
	
	@Column(name="action")
	private String action;
	
	@Column(name="time")
	private LocalDateTime time;

}
