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
import jakarta.persistence.Table;

@Entity
@Table(name="boarding_houses")
public class BoardingHouse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "location", nullable = false)
	private String location;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "capacity", nullable = false)
	private Integer capacity;
	
	@Column(name = "rooms_total")
	private Integer totalRooms;
	
	@Column(name = "price", nullable = false)
	private Float price;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="bh_id", nullable = true)
	private Set<Review> reviews = new HashSet<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="bh_id", nullable = false)
	private Set<Room> rooms = new HashSet<>();
	
	
	@OneToMany(mappedBy="boardingHouse", cascade=CascadeType.ALL)
	private Set<Image> images = new HashSet<>();
	


	@OneToMany(cascade=CascadeType.ALL)
	    @JoinColumn(name = "bh_id", nullable=false)
	    private Set<Booking> bookings = new HashSet<>();
	  
	  @ManyToOne(cascade=CascadeType.ALL)
	    @JoinColumn(name = "user_id", nullable=false)
	    private User  user;
	  
	  
	@Column(name = "created_at", nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAtt;
	
	  public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getTotalRooms() {
		return totalRooms;
	}

	public void setTotalRooms(Integer totalRooms) {
		this.totalRooms = totalRooms;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public LocalDateTime getUpdatedAtt() {
		return updatedAtt;
	}


	
	
}
