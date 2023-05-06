package com.studentmanagement.root.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.root.entity.Booking;

	@Repository
	public interface BookingRepo extends JpaRepository <Booking, Integer> {

	}