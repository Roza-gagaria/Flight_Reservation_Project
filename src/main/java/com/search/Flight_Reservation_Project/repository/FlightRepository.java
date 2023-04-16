package com.search.Flight_Reservation_Project.repository;

import java.util.Date;
//import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.search.Flight_Reservation_Project.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>{
	
	@Query("from Flight where depatureCity=:depatureCity and arrivalCity=:arrivalCity and dateOfDepature=:dateOfDepature")
	List<Flight> findFlights(@Param("depatureCity") String from, @Param("arrivalCity") String to, @Param("dateOfDepature") Date depatureDate);
}