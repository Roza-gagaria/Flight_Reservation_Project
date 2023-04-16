package com.search.Flight_Reservation_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.search.Flight_Reservation_Project.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
