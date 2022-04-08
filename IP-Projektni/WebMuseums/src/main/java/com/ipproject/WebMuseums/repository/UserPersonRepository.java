package com.ipproject.WebMuseums.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipproject.WebMuseums.model.UserPerson;
import com.ipproject.WebMuseums.model.UserStatus;

@Repository
public interface UserPersonRepository extends JpaRepository<UserPerson, Integer>{

	Optional<UserPerson> findByUsername(String username);
	long countByUsername(String username); 
	long countByEmail(String email);
	long countByToken(String token);
	long countByUserStatus(UserStatus userStatus);
	Optional<UserPerson> findByToken(String token);
	

}
