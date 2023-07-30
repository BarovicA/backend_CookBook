package com.cookbook.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Ingridient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	@NotNull(message = "Name must be included.")
	@Size(min=2,max = 30, message= "Name must be beetwen {min} and {max} characters long.")
	private String name;
	
	@Column(name = "serving_fats")
	@NotNull(message = "Serving size must be included.")
	private String servingSize;
	
	@Column
	@NotNull(message = "Calories must be included.")
	private Integer calories;
	
	@Column
	@NotNull(message = "Carbs must be included.")
	private Integer carbs;
	
	@Column
	@NotNull(message = "Sugars must be included.")
	private Integer sugars;
	
	@Column
	@NotNull(message = "Fats must be included.")
	private Integer fats;
	
	@Column(name = "saturated_fats")
	@NotNull(message = "Saturated fats must be included.")
	private Integer saturatedFats;
	
	@Column
	@NotNull(message = "Proteins must be included.")
	private Integer proteins;
	
	@Column
	@JsonIgnore
	private Boolean deleted= false;
	
	@Version
	private Integer version;

	@JsonIgnore
	@OneToMany(mappedBy = "ingridient", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<IngridientRecipe> ingridientRecipe = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "ingridient", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<IngridientAllergen> ingridientAllergen = new ArrayList<>();
	
	
	


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

	public Boolean getDeleted() {
		return deleted;
	}


	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
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


	public Ingridient(Long id,
			@NotNull(message = "Name must be included.") @Size(min = 2, max = 30, message = "Name must be beetwen {min} and {max} characters long.") String name,
			@NotNull(message = "Serving size must be included.") String servingSize,
			@NotNull(message = "Calories must be included.") Integer calories,
			@NotNull(message = "Carbs must be included.") Integer carbs,
			@NotNull(message = "Sugars must be included.") Integer sugars,
			@NotNull(message = "Fats must be included.") Integer fats,
			@NotNull(message = "Saturated fats must be included.") Integer saturatedFats,
			@NotNull(message = "Proteins must be included.") Integer proteins, Boolean deleted, Integer version,
			List<IngridientRecipe> ingridientRecipe, List<IngridientAllergen> ingridientAllergen) {
		super();
		this.id = id;
		this.name = name;
		this.servingSize = servingSize;
		this.calories = calories;
		this.carbs = carbs;
		this.sugars = sugars;
		this.fats = fats;
		this.saturatedFats = saturatedFats;
		this.proteins = proteins;
		this.deleted = deleted;
		this.version = version;
		this.ingridientRecipe = ingridientRecipe;
		this.ingridientAllergen = ingridientAllergen;
	}
	


	public Ingridient(
			@NotNull(message = "Name must be included.") @Size(min = 2, max = 30, message = "Name must be beetwen {min} and {max} characters long.") String name,
			@NotNull(message = "Serving size must be included.") String servingSize,
			@NotNull(message = "Calories must be included.") Integer calories,
			@NotNull(message = "Carbs must be included.") Integer carbs,
			@NotNull(message = "Sugars must be included.") Integer sugars,
			@NotNull(message = "Fats must be included.") Integer fats,
			@NotNull(message = "Saturated fats must be included.") Integer saturatedFats,
			@NotNull(message = "Proteins must be included.") Integer proteins, Boolean deleted, Integer version,
			List<IngridientRecipe> ingridientRecipe, List<IngridientAllergen> ingridientAllergen) {
		super();
		this.name = name;
		this.servingSize = servingSize;
		this.calories = calories;
		this.carbs = carbs;
		this.sugars = sugars;
		this.fats = fats;
		this.saturatedFats = saturatedFats;
		this.proteins = proteins;
		this.deleted = deleted;
		this.version = version;
		this.ingridientRecipe = ingridientRecipe;
		this.ingridientAllergen = ingridientAllergen;
	}

	public Ingridient(
			@NotNull(message = "Name must be included.") @Size(min = 2, max = 30, message = "Name must be beetwen {min} and {max} characters long.") String name,
			@NotNull(message = "Serving size must be included.") String servingSize,
			@NotNull(message = "Calories must be included.") Integer calories,
			@NotNull(message = "Carbs must be included.") Integer carbs,
			@NotNull(message = "Sugars must be included.") Integer sugars,
			@NotNull(message = "Fats must be included.") Integer fats,
			@NotNull(message = "Saturated fats must be included.") Integer saturatedFats,
			@NotNull(message = "Proteins must be included.") Integer proteins) {
		super();
		this.name = name;
		this.servingSize = servingSize;
		this.calories = calories;
		this.carbs = carbs;
		this.sugars = sugars;
		this.fats = fats;
		this.saturatedFats = saturatedFats;
		this.proteins = proteins;
	}


	public Ingridient() {
		super();
	}


	public Ingridient(
			@NotNull(message = "Name must be included.") @Size(min = 2, max = 30, message = "Name must be beetwen {min} and {max} characters long.") String name,
			@NotNull(message = "Serving size must be included.") String servingSize,
			@NotNull(message = "Calories must be included.") Integer calories,
			@NotNull(message = "Carbs must be included.") Integer carbs,
			@NotNull(message = "Sugars must be included.") Integer sugars,
			@NotNull(message = "Fats must be included.") Integer fats,
			@NotNull(message = "Saturated fats must be included.") Integer saturatedFats,
			@NotNull(message = "Proteins must be included.") Integer proteins, Boolean deleted) {
		super();
		this.name = name;
		this.servingSize = servingSize;
		this.calories = calories;
		this.carbs = carbs;
		this.sugars = sugars;
		this.fats = fats;
		this.saturatedFats = saturatedFats;
		this.proteins = proteins;
		this.deleted = deleted;
	}
	
	
}
