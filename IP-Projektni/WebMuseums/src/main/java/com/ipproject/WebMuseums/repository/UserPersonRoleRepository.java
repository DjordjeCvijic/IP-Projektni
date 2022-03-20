package com.ipproject.WebMuseums.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipproject.WebMuseums.model.UserPerson;
import com.ipproject.WebMuseums.model.UserPersonRole;

@Repository
public interface UserPersonRoleRepository extends JpaRepository<UserPersonRole, Integer>{

	List<UserPersonRole> findByUserPerson(UserPerson userPerson);

}
