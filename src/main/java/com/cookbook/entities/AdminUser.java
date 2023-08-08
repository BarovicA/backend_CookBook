package com.cookbook.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "Admin")
@DiscriminatorValue("Admin")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class AdminUser extends User {

	public AdminUser(String firstName, String lastName, String username, String password) {
		super();
		this.firstName = firstName;
	    this.lastName = lastName;
	    this.username = username;
	    this.password = password;

	}

	public AdminUser() {
		super();
	}

	
}
