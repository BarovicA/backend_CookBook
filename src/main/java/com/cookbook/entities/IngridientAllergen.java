package com.cookbook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name="Ingridient Allergen")
public class IngridientAllergen {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "allergen")
	private Allergen allergen;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "ingridient")
	private Ingridient ingridient;
	
	@Column
	@JsonIgnore
	private Boolean deleted;

	public IngridientAllergen() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Allergen getAllergen() {
		return allergen;
	}

	public void setAllergen(Allergen allergen) {
		this.allergen = allergen;
	}

	public Ingridient getIngridient() {
		return ingridient;
	}

	public void setIngridient(Ingridient ingridient) {
		this.ingridient = ingridient;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	
}
