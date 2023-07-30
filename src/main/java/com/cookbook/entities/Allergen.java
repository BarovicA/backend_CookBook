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
	
	
	@Column
	protected Boolean deleted;

	@Version
	private Integer version;

	public Allergen(Long id,
			@NotNull(message = "Name must be included.") @Size(min = 2, max = 30, message = "Name must be beetwen {min} and {max} characters long.") String name,
			@NotNull(message = "Name must be included.") String icon, List<AllergenRegularUser> allergenRegularUsers,
			List<IngridientAllergen> ingridientAllergens, Boolean deleted, Integer version) {
		super();
		this.id = id;
		this.name = name;
		this.icon = icon;
		this.allergenRegularUsers = allergenRegularUsers;
		this.ingridientAllergens = ingridientAllergens;
		this.deleted = deleted;
		this.version = version;
	}

	public Allergen(
			@NotNull(message = "Name must be included.") @Size(min = 2, max = 30, message = "Name must be beetwen {min} and {max} characters long.") String name,
			@NotNull(message = "Name must be included.") String icon, List<AllergenRegularUser> allergenRegularUsers,
			List<IngridientAllergen> ingridientAllergens, Boolean deleted, Integer version) {
		super();
		this.name = name;
		this.icon = icon;
		this.allergenRegularUsers = allergenRegularUsers;
		this.ingridientAllergens = ingridientAllergens;
		this.deleted = deleted;
		this.version = version;
	}

	public Allergen(
			@NotNull(message = "Name must be included.") @Size(min = 2, max = 30, message = "Name must be beetwen {min} and {max} characters long.") String name,
			@NotNull(message = "Name must be included.") String icon) {
		super();
		this.name = name;
		this.icon = icon;
	}

	public Allergen() {
		super();
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

	public List<AllergenRegularUser> getAllergenRegularUsers() {
		return allergenRegularUsers;
	}

	public void setAllergenRegularUsers(List<AllergenRegularUser> allergenRegularUsers) {
		this.allergenRegularUsers = allergenRegularUsers;
	}

	public List<IngridientAllergen> getIngridientAllergens() {
		return ingridientAllergens;
	}

	public void setIngridientAllergens(List<IngridientAllergen> ingridientAllergens) {
		this.ingridientAllergens = ingridientAllergens;
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

	public Allergen(
			@NotNull(message = "Name must be included.") @Size(min = 2, max = 30, message = "Name must be beetwen {min} and {max} characters long.") String name,
			@NotNull(message = "Name must be included.") String icon, Boolean deleted) {
		super();
		this.name = name;
		this.icon = icon;
		this.deleted = deleted;
	}

	

	
	
	
}
