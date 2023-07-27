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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;

@Entity
public class Ingridient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Column(name = "serving_fats")
	private String servingSize;
	
	@Column
	private Integer calories;
	
	@Column
	private Integer carbs;
	
	@Column
	private Integer sugars;
	
	@Column
	private Integer fats;
	
	@Column(name = "saturated_fats")
	private Integer saturatedFats;
	
	@Column
	private Integer proteins;
	
	@Column
	@JsonIgnore
	private Boolean deleted;
	
	@Version
	private Integer version;

	@JsonIgnore
	@OneToMany(mappedBy = "ingridient", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<IngridientRecipe> ingridientRecipe = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "ingridient", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<IngridientAllergen> ingridientAllergen = new ArrayList<>();
	
	
	public Ingridient() {
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


	public String getServingSize() {
		return servingSize;
	}


	public void setServingSize(String servingSize) {
		this.servingSize = servingSize;
	}


	public Integer getCalories() {
		return calories;
	}


	public void setCalories(Integer calories) {
		this.calories = calories;
	}


	public Integer getCarbs() {
		return carbs;
	}


	public void setCarbs(Integer carbs) {
		this.carbs = carbs;
	}


	public Integer getSugars() {
		return sugars;
	}


	public void setSugars(Integer sugars) {
		this.sugars = sugars;
	}


	public Integer getFats() {
		return fats;
	}


	public void setFats(Integer fats) {
		this.fats = fats;
	}


	public Integer getSaturatedFats() {
		return saturatedFats;
	}


	public void setSaturatedFats(Integer saturatedFats) {
		this.saturatedFats = saturatedFats;
	}


	public Integer getProteins() {
		return proteins;
	}


	public void setProteins(Integer proteins) {
		this.proteins = proteins;
	}


	public Integer getVersion() {
		return version;
	}


	public void setVersion(Integer version) {
		this.version = version;
	}


	public List<IngridientRecipe> getIngridientRecipe() {
		return ingridientRecipe;
	}


	public void setIngridientRecipe(List<IngridientRecipe> ingridientRecipe) {
		this.ingridientRecipe = ingridientRecipe;
	}


	public List<IngridientAllergen> getIngridientAllergen() {
		return ingridientAllergen;
	}


	public void setIngridientAllergen(List<IngridientAllergen> ingridientAllergen) {
		this.ingridientAllergen = ingridientAllergen;
	}
	
	
}