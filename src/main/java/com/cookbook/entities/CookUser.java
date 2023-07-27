package com.cookbook.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity(name = "Cook")
@DiscriminatorValue("Cook")
public class CookUser extends User {

	@JsonIgnore
	@OneToMany(mappedBy = "cook", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Recipe> Recipe = new ArrayList<>();
	
}
