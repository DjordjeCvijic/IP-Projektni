package com.ipproject.WebMuseums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipproject.WebMuseums.model.UserAction;

@Repository
public interface UserActionRepository  extends JpaRepository<UserAction, Integer>{

}
