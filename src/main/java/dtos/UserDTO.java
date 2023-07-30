package dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDTO {
	
	@Column
	@NotNull(message = "Firstname must be provided")
	@Size(min=2, max=20, message = "Name must be between {min} and {max} characters long.")
	protected String firstName;
	@Column
	@NotNull(message = "Lastname must be provided")
	@Size(min=2, max=20, message = "Name must be between {min} and {max} characters long.")
	protected String lastName;
	@Column
	@NotNull(message = "Username must be provided")
	@Size(min=5, max=20, message = "Name must be between {min} and {max} characters long.")
	protected String username;
	@Column
	@NotNull(message = "Password must be provided")
	@Size(min=6, max=30, message = "Name must be between {min} and {max} characters long.")
	protected String password;
	
	@Column
	protected Boolean deleted;
	@Column
	protected Integer version;
	
	public UserDTO() {
		super();
	}

	public UserDTO(
			@NotNull(message = "Firstname must be provided") @Size(min = 2, max = 20, message = "Name must be between {min} and {max} characters long.") String firstName,
			@NotNull(message = "Lastname must be provided") @Size(min = 2, max = 20, message = "Name must be between {min} and {max} characters long.") String lastName,
			@NotNull(message = "Username must be provided") @Size(min = 5, max = 20, message = "Name must be between {min} and {max} characters long.") String username,
			@NotNull(message = "Password must be provided") @Size(min = 5, max = 20, message = "Name must be between {min} and {max} characters long.") String password,
			 Boolean deleted, Integer version) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		
		this.deleted = deleted;
		this.version = version;
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
