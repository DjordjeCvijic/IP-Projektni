package com.ipproject.WebMuseums.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipproject.WebMuseums.model.UserStatus;

@Repository
public interface UserStatusRepository extends JpaRepository<UserStatus, Integer>{
	Optional<UserStatus>findByUserStatusId(Integer userStatusId);

}
