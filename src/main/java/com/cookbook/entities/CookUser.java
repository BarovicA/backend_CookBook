package com.cookbook.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "Cook")
@DiscriminatorValue("Cook")
public class CookUser extends User {

}
