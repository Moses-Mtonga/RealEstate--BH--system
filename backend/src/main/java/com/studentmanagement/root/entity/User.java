package com.studentmanagement.root.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User implements UserDetails {
	
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
	    
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "user_role",
	               joinColumns = @JoinColumn(name = "user_id"),
	               inverseJoinColumns = @JoinColumn(name = "role_id"))
	    private Set<Role> roles = new HashSet<>();
	    
	    public Set<Role> getRoles() {
			return roles;
		}

		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}
	    
	    
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

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
		    Collection<Role> roles = this.getRoles();
		    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		    for (Role role : roles) {
		        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		    }
		    return authorities;
		}
		

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return email;
		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}

		

	    
	    
}
