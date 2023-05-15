package com.studentmanagement.root.entity;



import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="roles")

public class Role {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;

	 @Column(name = "role_name")
	    private String roleName;

	    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	    private Set<User> users = new HashSet<>();

		public String getRoleName() {
			return roleName;
		}

		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}

		public Integer getId() {
			return id;
		}

		public Set<User> getUsers() {
			return users;
		}
	    
	    
}
