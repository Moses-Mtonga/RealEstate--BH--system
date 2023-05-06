package com.studentmanagement.root.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.root.entity.Booking;
import com.studentmanagement.root.repository.BookingRepo;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepo bookingRepository;
	
	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}
	
	public Booking getBookingById(Integer id) {
		Optional<Booking> existingBooking = bookingRepository.findById(id);
		if(existingBooking.isPresent()){
			return existingBooking.get();
		} 
		else {
		return null;
	    }
	}
	
	public Booking createBooking(Booking booking) {
		return bookingRepository.save(booking);
	}
	
	public Booking updateBooking(Integer id, Booking booking) {
		Optional<Booking> bookingData = bookingRepository.findById(id);
		
		if (bookingData.isPresent()) {
			Booking bookingToUpdate = bookingData.get();
			bookingToUpdate.setCheckInDate(booking.getCheckInDate());
			bookingToUpdate.setCheckOutDate(booking.getCheckOutDate());
			bookingToUpdate.setIsApproved(booking.getIsApproved());
			bookingToUpdate.setTotalPrice(booking.getTotalPrice());
			return bookingRepository.save(bookingToUpdate);
		}
		
		return null;
	}
	
	public String deleteBooking(Integer id) {
		Optional<Booking> existingBooking = bookingRepository.findById(id);
				if(existingBooking.isPresent()) {
					bookingRepository.delete(existingBooking.get());
					return "deleted";
				} else {
					return null;
				}

	}

}

