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
@Table(name="Allergen RegularUser")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class AllergenRegularUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "allergen")
	private Allergen allergen;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "regUser")
	private RegularUser regUser;
	
	@Column
	@JsonIgnore
	private Boolean deleted;

	public AllergenRegularUser() {
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

	public RegularUser getRegUser() {
		return regUser;
	}

	public void setRegUser(RegularUser regUser) {
		this.regUser = regUser;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	
	
}
