package com.ipproject.WebMuseums.dto;

import com.ipproject.WebMuseums.model.UserPerson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPersonResponseDto extends UserPerson{
	private String status;//1 ok,2 usernamealready exists,3 e mail already exists 

}
