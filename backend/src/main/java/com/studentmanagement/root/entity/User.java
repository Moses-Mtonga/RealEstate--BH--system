package com.studentmanagement.root.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;

	 @Column(name="first_name", nullable = false)
	 private String firstName;
	
	 @Column(name="last_name", nullable = false)
	 private String lastName;
	 
	 @Column(name="email", nullable = false)
	 private String email;
	
	 @Column(name="phone", nullable = false)
	 private String phone;
	 
	 @Column(name="password", nullable = false)
	 private String password;
	 
	 @Column(name="is_landlord", nullable = false)
	 private Boolean isLandlord;
	 
	  @Column(name = "created_at", nullable = false, updatable = false)
	    @CreationTimestamp
	    private LocalDateTime createdAt;

	    @Column(name = "updated_at", nullable = false)
	    @UpdateTimestamp
	    private LocalDateTime updatedAt;
	    
	    @ManyToOne
	    @JoinColumn(name = "room_id", nullable = true)
	    private Room room;
	    
	    
	    @OneToOne(mappedBy="user", cascade=CascadeType.ALL)
		private Image images;

	    @OneToMany(cascade=CascadeType.ALL)
	    @JoinColumn(name = "user_id" , nullable=false)
	    private Set<Booking> bookings = new HashSet<>();
	    
	    @OneToMany(mappedBy="user",  cascade=CascadeType.ALL)
	    private Set<BoardingHouse> boardingHouses = new HashSet<>();
	    
	    
		public Set<BoardingHouse> getBoardingHouses() {
			return boardingHouses;
		}

		public Set<Booking> getBookings() {
			return bookings;
		}

		public void setBookings(Set<Booking> bookings) {
			this.bookings = bookings;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Boolean getIsLandlord() {
			return isLandlord;
		}

		public void setIsLandlord(Boolean isLandlord) {
			this.isLandlord = isLandlord;
		}

		public Room getRoom() {
			return room;
		}

		public void setRoom(Room room) {
			this.room = room;
		}

		public Integer getId() {
			return id;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public LocalDateTime getUpdatedAt() {
			return updatedAt;
		}
	    
	    
}
