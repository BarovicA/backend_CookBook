package com.cookbook.entities;

import java.util.ArrayList;
import java.util.List;

import com.cookbook.dto.AdminUserDTO;
import com.cookbook.dto.CookUserDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity(name = "Cook")
@DiscriminatorValue("Cook")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class CookUser extends User  {
	
//
//	
	//@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	//	
//	@Column
//	@NotNull(message = "Firstname must be included.")
//	@Size(min=2,max = 30, message= "Firstname must be beetwen {min} and {max} characters long.")
//	protected String firstName;
//	
//	@Column
//	@NotNull(message = "Lastname must be included.")
//	@Size(min=2,max = 30, message= "Lastname must be beetwen {min} and {max} characters long.")
//	protected String lastName;
//	
//	
//	@Column
//	@NotNull(message = "Username must be included.")
//	@Size(min=5, max = 20, message= "Username must be beetwen {min} and {max} characters long.")
//	protected String username;
//	
//	
//	@Column
//	@NotNull(message = "Password must be included.")
//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,30}$", message = "Password must be at least 6 characters long and contain a lowercase, an upercase letter and a number")
//	@Size(min=6, max = 30, message= "Password must be beetwen {min} and {max} characters long.")
//	protected String password;
//	
	@JsonIgnore
	@OneToMany(mappedBy = "cook", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, orphanRemoval = true)
    private List<UserRole> userRoles = new ArrayList<>();
	
	@Column
	@JsonIgnore
	private Boolean deleted = false;

	@JsonIgnore
	@OneToMany(mappedBy = "cook", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Recipe> Recipe = new ArrayList<>();

	
	public CookUser(List<Recipe> recipe) {
		super();
		Recipe = recipe;
	}


	public CookUser() {
		super();
	}


	public CookUser(Long id,
			//@NotNull(message = "Firstname must be included.") @Size(min = 2, max = 30, message = "Firstname must be beetwen {min} and {max} characters long.") 
			String firstName,
			//@NotNull(message = "Lastname must be included.") @Size(min = 2, max = 30, message = "Lastname must be beetwen {min} and {max} characters long.") 
			String lastName,
			//@NotNull(message = "Username must be included.") @Size(min = 5, max = 20, message = "Username must be beetwen {min} and {max} characters long.") 
			String username,
			//@NotNull(message = "Password must be included.") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,30}$", message = "Password must be at least 6 characters long and contain a lowercase, an upercase letter and a number") @Size(min = 6, max = 30, message = "Password must be beetwen {min} and {max} characters long.") String password,
			List<UserRole> userRoles, Boolean deleted, List<com.cookbook.entities.Recipe> recipe) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.userRoles = userRoles;
		this.deleted = deleted;
		Recipe = recipe;
	}


//	public Long getId() {
//		return id;
	//}


//	public void setId(Long id) {
//		this.id = id;
//	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<UserRole> getUserRoles() {
		return userRoles;
	}


	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}


	public Boolean getDeleted() {
		return deleted;
	}


	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}


	public List<Recipe> getRecipe() {
		return Recipe;
	}


	public void setRecipe(List<Recipe> recipe) {
		Recipe = recipe;
	}
	
	public CookUser(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;

	}
	
	public CookUser(CookUserDTO cookUserDTO) {
		this.firstName = cookUserDTO.getFirstName();
		this.lastName = cookUserDTO.getLastName();
		this.username = cookUserDTO.getUsername();
		this.password = cookUserDTO.getPassword();
	}


}
