package com.cookbook.dto;

import com.cookbook.entities.CookUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CookUserDTO {
	
	
	@Column(nullable=false,name="name_cook")
	@NotNull(message="First name must be provided")
	@Size(min=2,max=30, message= "First name must be beetwen {min} and {max} characters long.")


	private String firstName;
	
	
	@Column(nullable=false,name="Last_name_Cook")
	@NotNull(message="Last name must be provided")
	@Size(min=2,max=30, message= "Last name must be beetwen {min} and {max} characters long.")
	
	private String lastName;
	
	@Column(nullable=false, unique = true)
	@NotNull(message="username must be provided")
	@Size(min=5,max=20, message= "username must be beetwen {min} and {max} characters long.")
	private String username;
	
	@Column(nullable=false,name="password")
	@NotNull(message="Password must be provided")
	@Size(min=6,max=30, message= "password must be beetwen {min} and {max} characters long.")

	protected String password;
	

	
	 public CookUserDTO() {
	        super();
	 }

	public CookUserDTO(
			String firstName,
			String lastName,
			String username,
			String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		
	}
		 public CookUserDTO(CookUser cookUser) {
		    	this.firstName = cookUser.getFirstName();
				this.lastName = cookUser.getLastName();
				this.username = cookUser.getUsername();
				this.password = cookUser.getPassword();
				
	
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
	
	
	
	
	

}