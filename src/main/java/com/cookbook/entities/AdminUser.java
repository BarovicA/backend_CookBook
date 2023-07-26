package com.cookbook.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "Admin")
@DiscriminatorValue("Admin")
public class AdminUser extends User {
	
	

}
