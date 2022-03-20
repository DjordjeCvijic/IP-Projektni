package com.ipproject.WebMuseums.compositekey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class UserPersonRoleKey implements Serializable{
	
	
	@Column(name = "roleId")
    private Integer roleId;

    @Column(name = "userPersonId")
    private Integer userPersonId;
}
