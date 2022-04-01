package com.ipproject.WebMuseums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipproject.WebMuseums.model.VirtualTour;

@Repository
public interface VirtualTourRepository extends JpaRepository<VirtualTour, Integer>{

}
