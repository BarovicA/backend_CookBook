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
public class Allergen {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	@NotNull(message = "Name must be included.")
	@Size(min=2,max = 30, message= "Name must be beetwen {min} and {max} characters long.")
	private String name;
	
	@Column
	@NotNull(message = "Name must be included.")
	private String icon;
	

	@JsonIgnore
	@OneToMany(mappedBy = "allergen", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<AllergenRegularUser> allergenRegularUsers = new ArrayList<>();
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "allergen", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<IngridientAllergen> ingridientAllergens = new ArrayList<>();
	
	@JsonIgnore
	@Column
	protected Boolean deleted;
	
	@JsonIgnore
	@Version
	private Integer version;

	public Allergen() {
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
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
	
	
}
