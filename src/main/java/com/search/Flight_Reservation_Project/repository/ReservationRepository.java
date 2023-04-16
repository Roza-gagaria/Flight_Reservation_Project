package com.search.Flight_Reservation_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.search.Flight_Reservation_Project.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
