package com.ipproject.WebMuseums.dto;

import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInformationDto {
	
	private Integer activeUsersCount;//trenutno ulogovani
	private Integer registeredUsersCount;//svi

	List<LoginCount> loginCountList=new LinkedList<>();
	

}
