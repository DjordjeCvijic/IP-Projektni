package com.ipproject.WebMuseums.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipproject.WebMuseums.model.Museum;
import com.ipproject.WebMuseums.model.VirtualTour;

@Repository
public interface VirtualTourRepository extends JpaRepository<VirtualTour, Integer>{

	List<VirtualTour> findAllByMuseum(Museum museum);

}
