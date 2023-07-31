package com.cookbook.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity(name = "Cook")
@DiscriminatorValue("Cook")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class CookUser extends User {

	@JsonIgnore
	@OneToMany(mappedBy = "cook", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Recipe> Recipe = new ArrayList<>();

	
	public CookUser(List<Recipe> recipe) {
		super();
		Recipe = recipe;
	}


	public CookUser() {
		super();
	}


	public CookUser(String firstName, String lastName, String username, String password) {
		super();
		this.firstName = firstName;
	    this.lastName = lastName;
	    this.username = username;
	    this.password = password;

	}
	


	public List<Recipe> getRecipe() {
		return Recipe;
	}

	public void setRecipe(List<Recipe> recipe) {
		Recipe = recipe;
	}



	
	    
}
