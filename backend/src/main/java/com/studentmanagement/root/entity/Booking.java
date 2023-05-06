package com.studentmanagement.root.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bookings")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="total_price")
	private Float totalPrice;
	
	@Column(name="is_approved")
	private Boolean isApproved;
	
	@Column(name="check_in_date")
	private LocalDateTime checkInDate;
	
	@Column(name="check_out_date")
	private LocalDateTime checkOutDate;
	
	@Column(name="booking_date")
	@CreationTimestamp
	private LocalDateTime bookingDate;
	
	@Column(name="updated_booking_date")
	@UpdateTimestamp
	private LocalDateTime updatedBookingDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public LocalDateTime getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDateTime checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDateTime getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDateTime checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public LocalDateTime getUpdatedBookingDate() {
		return updatedBookingDate;
	}
	
	
}
