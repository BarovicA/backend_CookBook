package com.cookbook.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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

	@Column
	@JsonIgnore
	private Boolean deleted = false;
	
	public CookUser(List<com.cookbook.entities.Recipe> recipe) {
		super();
		Recipe = recipe;
	}


	public CookUser(String firstName, String lastName, String username, String password) {
		super();
	}


	public List<Recipe> getRecipe() {
		return Recipe;
	}

	public void setRecipe(List<Recipe> recipe) {
		Recipe = recipe;
	}


	public Boolean getDeleted() {
		return deleted;
	}


	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	
	
}
