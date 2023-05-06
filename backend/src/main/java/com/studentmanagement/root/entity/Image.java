package com.studentmanagement.root.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="images")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "owner_type", nullable = false)
	private ownerType imageOwner;
	
	@Column(name = "data", nullable = false)
	private Byte[] data;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="bh_id")
	private BoardingHouse boardingHouse;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="room_id")
	private Room room;
	
	
	public enum ownerType {
        room,
        BOARDING_HOUSE,
        user
    }
	
}

