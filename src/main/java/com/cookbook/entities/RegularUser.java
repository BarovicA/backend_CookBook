package com.cookbook.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "Regular_user")
@DiscriminatorValue("Regular_user")
public class RegularUser {

}
