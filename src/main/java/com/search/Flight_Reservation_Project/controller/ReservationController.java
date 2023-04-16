package com.search.Flight_Reservation_Project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.search.Flight_Reservation_Project.dto.ReservationRequest;
import com.search.Flight_Reservation_Project.entity.Reservation;
import com.search.Flight_Reservation_Project.service.ReservationService;



@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;

	@RequestMapping("/confirmReservation")
	public String confirmReservation(ReservationRequest request, ModelMap modelMap) {
	//	System.out.println(reservation.getFlightId());
		Reservation reservationId = reservationService.bookFlight(request);
		modelMap.addAttribute("reservationId", reservationId.getId());
       
		return"confirmReservation";
	}
}
