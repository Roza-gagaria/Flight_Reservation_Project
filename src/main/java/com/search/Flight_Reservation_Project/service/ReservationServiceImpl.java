package com.search.Flight_Reservation_Project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.search.Flight_Reservation_Project.dto.ReservationRequest;
import com.search.Flight_Reservation_Project.entity.Flight;
import com.search.Flight_Reservation_Project.entity.Passenger;
import com.search.Flight_Reservation_Project.entity.Reservation;
import com.search.Flight_Reservation_Project.repository.FlightRepository;
import com.search.Flight_Reservation_Project.repository.PassengerRepository;
import com.search.Flight_Reservation_Project.repository.ReservationRepository;
import com.search.Flight_Reservation_Project.utilities.EmailUtil;
import com.search.Flight_Reservation_Project.utilities.PDFgenerator;


@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
    private	PDFgenerator pdFgenerator;
	
	@Autowired
	private EmailUtil emailUtil;
	

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setLastName(request.getLastName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);
		
		long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		String filePath = "E:\\stsv4.17\\Flight_Reservation_Project\\tickets\\reservation"+reservation.getId()+".pdf";
		reservationRepo.save(reservation);
		
		pdFgenerator.generateItinerary(reservation, filePath);
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		
		return reservation;
	}

}
