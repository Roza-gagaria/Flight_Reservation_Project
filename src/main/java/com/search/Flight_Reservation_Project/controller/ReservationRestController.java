package com.search.Flight_Reservation_Project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.search.Flight_Reservation_Project.dto.ReservationUpdateRequest;
import com.search.Flight_Reservation_Project.entity.Reservation;
import com.search.Flight_Reservation_Project.repository.ReservationRepository;

@RestController
public class ReservationRestController {
	
	@Autowired
    private  ReservationRepository reservationRepo;


	//http://localhost:8080/flights2/reservation/1
	@RequestMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		Optional<Reservation> findById = reservationRepo.findById(id);
		Reservation reservation = findById.get();
		return reservation;
	}
	
	@RequestMapping("/reservation")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Optional<Reservation> findById = reservationRepo.findById(request.getId());
		Reservation reservation = findById.get();
		reservation.setCheckedIn(request.isCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());
	    return	reservationRepo.save(reservation);
	
	}
}