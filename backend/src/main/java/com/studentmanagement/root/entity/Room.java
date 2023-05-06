package com.studentmanagement.root.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="rooms")
public class Room {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;

	 @Column( nullable = true)
	 private String description;
	 
	 @Column(name="capacity", nullable = false)
	 private Integer capacity;
	 
	 @Column( name="room_number",nullable = false)
	 private Integer roomNumber;
	 
	 @Column( nullable = false)
	 private Float price;
	 
	 @Column( nullable = true)
	 private Boolean availability;
	 
	 @OneToMany(mappedBy = "room")
	    private Set<User> users = new HashSet<>();
	 
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name="room_id", nullable=true)
	 private Set<Review> reviews = new HashSet<>();
	 
	  @OneToMany(cascade=CascadeType.ALL)
	    @JoinColumn(name = "room_id" , nullable=false)
	    private Set<Booking> bookings = new HashSet<>();
	 
	 @OneToMany(mappedBy="room", cascade=CascadeType.ALL)
		private Set<Image> images = new HashSet<>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCapcity() {
		return capacity;
	}

	public void setCapcity(Integer capcity) {
		this.capacity = capcity;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Integer getId() {
		return id;
	}
	 
}
