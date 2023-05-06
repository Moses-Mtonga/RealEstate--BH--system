package com.studentmanagement.root.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reviews")
public class Review {
	
@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(name="rating", nullable = false)
private Integer rating;

@Column(name="review_description",  nullable = true)
private  String description;

@ManyToOne
@JoinColumn(name="user_id", nullable=false)
private User user;


@Column(name = "created_at", nullable = false, updatable = false)
@CreationTimestamp
private LocalDateTime createdAt;

@Column(name = "updated_at", nullable = false)
@UpdateTimestamp
private LocalDateTime updatedAt;

public Integer getRating() {
	return rating;
}

public void setRating(Integer rating) {
	this.rating = rating;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
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


