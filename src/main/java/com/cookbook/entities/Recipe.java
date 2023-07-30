package com.cookbook.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	@NotNull(message = "Name must be included.")
	@Size(min = 2, max = 30, message = "Name must be beetwen {min} and {max} characters long.")
	private String name;

	@Column
	@NotNull(message = "Description must be included.")
	@Size(min = 2, max = 500, message = "Description must be beetwen {min} and {max} characters long.")
	private String decription;

	@Column
	@NotNull(message = "Steps must be included.")
	private String steps;

	@Column
	@NotNull(message = "Time to prepare must be included.")
	private Integer timeToPrepare;

	@Column
	@NotNull(message = "Expected yield must be included.")
	private String expectedYield;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "cook")
	private CookUser cook;

	@JsonIgnore
	@OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<IngridientRecipe> ingridientRecipe = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<UserRegularRecipe> userRegularRecipe = new ArrayList<>();

	@Column
	@JsonIgnore
	private Boolean deleted;

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Recipe() {
		this.deleted = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public String getSteps() {
		return steps;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}

	public Integer getTimeToPrepare() {
		return timeToPrepare;
	}

	public void setTimeToPrepare(Integer timeToPrepare) {
		this.timeToPrepare = timeToPrepare;
	}

	public String getExpectedYield() {
		return expectedYield;
	}

	public void setExpectedYield(String expectedYield) {
		this.expectedYield = expectedYield;
	}

	public List<IngridientRecipe> getIngridientRecipe() {
		return ingridientRecipe;
	}

	public void setIngridientRecipe(List<IngridientRecipe> ingridientRecipe) {
		this.ingridientRecipe = ingridientRecipe;
	}

	public CookUser getCook() {
		return cook;
	}

	public void setCook(CookUser cook) {
		this.cook = cook;
	}

	public List<UserRegularRecipe> getUserRegularRecipe() {
		return userRegularRecipe;
	}

	public void setUserRegularRecipe(List<UserRegularRecipe> userRegularRecipe) {
		this.userRegularRecipe = userRegularRecipe;
	}

}
