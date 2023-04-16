package com.search.Flight_Reservation_Project.service;

import com.search.Flight_Reservation_Project.dto.ReservationRequest;
import com.search.Flight_Reservation_Project.entity.Reservation;

public interface ReservationService {
	
	Reservation bookFlight(ReservationRequest request);

}
