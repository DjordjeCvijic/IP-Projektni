package com.ipproject.WebMuseums.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ipproject.WebMuseums.compositekey.UserPersonRoleKey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "user_person_role")
public class UserPersonRole {
	
	@EmbeddedId
    @Column(name = "user_person_role_key")
    UserPersonRoleKey userPersonRoleKey;

	
	@ManyToOne
    @MapsId("userPersonId")//kako se zove u veznoj tabel//mora se poklapati kao u kljucu
    @JoinColumn(name="user_id", nullable = false)//kako se zove u ovoj
    @JsonIgnore
    private UserPerson userPerson;


    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name="role_id", nullable = false)
    private Role role;
    
    
    
}
