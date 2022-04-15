package com.ipproject.WebMuseums.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipproject.WebMuseums.model.LoginHistory;
import com.ipproject.WebMuseums.model.Museum;
import com.ipproject.WebMuseums.model.VirtualTour;

@Repository
public interface VirtualTourRepository extends JpaRepository<VirtualTour, Integer>{

	List<VirtualTour> findAllByMuseum(Museum museum);
	Optional<VirtualTour> findByVirtualTourId(Integer virtualTourId);
	List<VirtualTour> findAllByStartDateTime(LocalDateTime start);
	List<VirtualTour> findAllByStartDateTimeBefore(LocalDateTime localDateTime);
	List<VirtualTour> findAllByStartDateTimeAfter(LocalDateTime localDateTime);
}
