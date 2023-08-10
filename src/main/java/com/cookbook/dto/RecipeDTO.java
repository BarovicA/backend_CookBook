package com.cookbook.dto;

import java.util.ArrayList;
import java.util.List;

import com.cookbook.entities.CookUser;


public class RecipeDTO {

	
	private String name;

	private String decription;

	private String steps;

	private Integer timeToPrepare;

	private Integer expectedYieldInGrams;

	private CookUser cook;
	
	private Integer energy;
	
	private List<String> allergens;
	
	

	public RecipeDTO() {
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

	public Integer getExpectedYieldInGrams() {
		return expectedYieldInGrams;
	}

	public void setExpectedYieldInGrams(Integer expectedYieldInGrams) {
		this.expectedYieldInGrams = expectedYieldInGrams;
	}

	public CookUser getCook() {
		return cook;
	}

	public void setCook(CookUser cook) {
		this.cook = cook;
	}

	public Integer getEnergy() {
		return energy;
	}

	public void setEnergy(Integer energy) {
		this.energy = energy;
	}

	public List<String> getAllergens() {
		return allergens;
	}

	public void setAllergens(List<String> allergens) {
		this.allergens = allergens;
	}
	
	
}
