package com.ipproject.WebMuseums.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "user_person")
public class UserPerson {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userPersonId;

    @Column(name ="username",nullable = false)
    private String username;

    @Column(name ="first_name",nullable = false)
    private String firstName;

    @Column(name ="last_name",nullable = false)
    private String lastName;

    @Column(name ="email",nullable = false)
    private String email;

    @Column(name ="password",nullable = false)
    private String password;

    
    @Column(name="token")
    private String token;

    @ManyToOne
    @JoinColumn(name = "user_status_id")
    private UserStatus userStatus;
	
    
    

}
