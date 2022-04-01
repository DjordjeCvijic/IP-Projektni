package com.ipproject.WebMuseums.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipproject.WebMuseums.model.Museum;

@Repository
public interface MuseumRepository extends JpaRepository<Museum, Integer>{

	Optional<Museum> findByMuseumId(Integer museumId);

}
