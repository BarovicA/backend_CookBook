package com.cookbook.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegularUserDTO {
	
    @NotNull(message = "Firstname must be provided")
    @Size
    (min = 2, max = 20, message = "Name must be between {min} and {max} characters long.")
    protected String firstName;

    @NotNull(message = "Lastname must be provided")
    @Size(min = 2, max = 20, message = "Name must be between {min} and {max} characters long.")
    protected String lastName;

    @NotNull(message = "Username must be provided")
    @Size(min = 5, max = 20, message = "Name must be between {min} and {max} characters long.")
    protected String username;

    @NotNull(message = "Password must be provided")
    @Size(min = 6, max = 30, message = "Name must be between {min} and {max} characters long.")
    protected String password;

    public RegularUserDTO() {
        super();
    }

    public RegularUserDTO(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
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
