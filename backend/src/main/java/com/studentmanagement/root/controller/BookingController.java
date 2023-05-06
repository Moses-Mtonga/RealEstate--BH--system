package com.studentmanagement.root.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagement.root.entity.Booking;
import com.studentmanagement.root.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping
	public ResponseEntity<List<Booking>> getAllBookings() {
		List<Booking> bookings = bookingService.getAllBookings();
		return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable("id") Integer id) {
		Booking bookingData = bookingService.getBookingById(id);
		if (bookingData!=null) {
			return new ResponseEntity<Booking>(bookingData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
		Booking createdBooking = bookingService.createBooking(booking);
		return new ResponseEntity<Booking>(createdBooking, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Booking> updateBooking(@PathVariable("id") Integer id, @RequestBody Booking booking) {
		Booking updatedBooking = bookingService.updateBooking(id, booking);
		
		if (updatedBooking != null) {
			return new ResponseEntity<Booking>(updatedBooking, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteBooking(@PathVariable("id") Integer id) {
		String deletedBooking = bookingService.deleteBooking(id);
		if(deletedBooking =="deleted") {
			return new ResponseEntity<String>(deletedBooking, HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<String>(deletedBooking, HttpStatus.NOT_FOUND);
		}
	}

}

