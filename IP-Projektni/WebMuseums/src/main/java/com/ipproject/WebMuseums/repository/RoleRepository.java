package com.ipproject.WebMuseums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipproject.WebMuseums.model.Role;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Integer>{

}
