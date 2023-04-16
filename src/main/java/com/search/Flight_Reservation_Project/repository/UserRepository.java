package com.search.Flight_Reservation_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.search.Flight_Reservation_Project.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String emailId);

}
