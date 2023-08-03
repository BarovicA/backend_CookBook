package com.cookbook.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AdminUserDTO {
	
	@NotNull(message = "Firstname must be provided")
    @Size(min = 2, max = 20, message = "Name must be between {min} and {max} characters long.")
    protected String firstname;

    @NotNull(message = "Lastname must be provided")
    @Size(min = 2, max = 20, message = "Name must be between {min} and {max} characters long.")
    protected String lastname;

    @NotNull(message = "Username must be provided")
    @Size(min = 5, max = 20, message = "Name must be between {min} and {max} characters long.")
    protected String username;

    @NotNull(message = "Password must be provided")
    @Size(min = 6, max = 30, message = "Name must be between {min} and {max} characters long.")
    protected String password;

    public AdminUserDTO() {
        super();
        
        
    }

    public AdminUserDTO(
			@NotNull(message = "Firstname must be provided") @Size(min = 2, max = 20, message = "Name must be between {min} and {max} characters long.") String firstName,
			@NotNull(message = "Lastname must be provided") @Size(min = 2, max = 20, message = "Name must be between {min} and {max} characters long.") String lastName,
			@NotNull(message = "Username must be provided") @Size(min = 5, max = 20, message = "Name must be between {min} and {max} characters long.") String username,
			@NotNull(message = "Password must be provided") @Size(min = 6, max = 30, message = "Name must be between {min} and {max} characters long.") String password) {
		super();
		this.firstname = firstName;
		this.lastname = lastName;
		this.username = username;
		this.password = password;
	}

	public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
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


