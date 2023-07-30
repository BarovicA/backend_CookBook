package com.cookbook.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "User_Type")
public abstract class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	@NotNull(message = "Firstname must be included.")
	@Size(min=2,max = 30, message= "Firstname must be beetwen {min} and {max} characters long.")
	protected String firstName;
	
	@Column
	@NotNull(message = "Lastname must be included.")
	@Size(min=2,max = 30, message= "Lastname must be beetwen {min} and {max} characters long.")
	protected String lastName;
	
	
	@Column
	@NotNull(message = "Username must be included.")
	@Size(min=5, max = 20, message= "Username must be beetwen {min} and {max} characters long.")
	protected String username;
	
	
	@Column
	@NotNull(message = "Password must be included.")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,30}$", message = "Password must be at least 6 characters long and contain a lowercase, an upercase letter and a number")
	@Size(min=6, max = 30, message= "Password must be beetwen {min} and {max} characters long.")
	protected String password;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, orphanRemoval = true)
    private List<UserRole> userRoles = new ArrayList<>();
	
	


	public User() {
	}
	
	

	public User(
			@NotNull(message = "Firstname must be included.") @Size(min = 2, max = 30, message = "Firstname must be beetwen {min} and {max} characters long.") String firstName,
			@NotNull(message = "Lastname must be included.") @Size(min = 2, max = 30, message = "Lastname must be beetwen {min} and {max} characters long.") String lastName,
			@NotNull(message = "Username must be included.") @Size(min = 5, max = 20, message = "Username must be beetwen {min} and {max} characters long.") String username,
			@NotNull(message = "Password must be included.") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,30}$", message = "Password must be at least 6 characters long and contain a lowercase, an upercase letter and a number") @Size(min = 6, max = 30, message = "Password must be beetwen {min} and {max} characters long.") String password,
			List<UserRole> userRoles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.userRoles = userRoles;
		
	}



	public User(Long id,
			@NotNull(message = "Firstname must be included.") @Size(min = 2, max = 30, message = "Firstname must be beetwen {min} and {max} characters long.") String firstName,
			@NotNull(message = "Lastname must be included.") @Size(min = 2, max = 30, message = "Lastname must be beetwen {min} and {max} characters long.") String lastName,
			@NotNull(message = "Username must be included.") @Size(min = 5, max = 20, message = "Username must be beetwen {min} and {max} characters long.") String username,
			@NotNull(message = "Password must be included.") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,30}$", message = "Password must be at least 6 characters long and contain a lowercase, an upercase letter and a number") @Size(min = 6, max = 30, message = "Password must be beetwen {min} and {max} characters long.") String password,
			List<UserRole> userRoles, Boolean deleted, Integer version) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.userRoles = userRoles;
		
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	

	
	

	
	
}
