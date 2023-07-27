package com.cookbook.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity(name = "Regular_user")
@DiscriminatorValue("Regular_user")
public class RegularUser extends User {

	
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<UserRegularRecipe> userRegularRecipe = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "regUser", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<AllergenRegularUser> allergenRegularUser = new ArrayList<>();

	@Column
	@JsonIgnore
	private Boolean deleted;
	
	public RegularUser() {
	}

	public List<UserRegularRecipe> getUserRegularRecipe() {
		return userRegularRecipe;
	}

	public void setUserRegularRecipe(List<UserRegularRecipe> userRegularRecipe) {
		this.userRegularRecipe = userRegularRecipe;
	}

	public List<AllergenRegularUser> getAllergenRegularUser() {
		return allergenRegularUser;
	}

	public void setAllergenRegularUser(List<AllergenRegularUser> allergenRegularUser) {
		this.allergenRegularUser = allergenRegularUser;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
}
