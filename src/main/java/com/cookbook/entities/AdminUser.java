package com.cookbook.entities;

import java.util.ArrayList;
import java.util.List;

import com.cookbook.dto.AdminUserDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

@Entity(name = "Admin")
@DiscriminatorValue("Admin")
public class AdminUser extends User {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//
//	@Column
//	public String firstName;
//
//	@Column
//	public String lastName;
//
//	@Column
//	public String username;
//
//	@Column
//	public String password;

	@JsonIgnore
	@OneToMany(mappedBy = "admin", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, orphanRemoval = true)
	private List<UserRole> userRoles = new ArrayList<>();

	@Column
	@JsonIgnore
	private Boolean deleted = false;

	public AdminUser() {
		super();
	}

	public AdminUser(Long id,

			String firstName, String lastName, String username, String password, List<UserRole> userRoles,
			Boolean deleted) {
		super();
		//this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.userRoles = userRoles;
		this.deleted = deleted;
	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public List<UserRole> getUserRoles() {
//		return userRoles;
//	}
//
//	public void setUserRoles(List<UserRole> userRoles) {
//		this.userRoles = userRoles;
//	}
//
//	public Boolean getDeleted() {
//		return deleted;
//	}
//
//	public void setDeleted(Boolean deleted) {
//		this.deleted = deleted;
//	}
//
	public AdminUser(String firstName, String lastName, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public AdminUser(AdminUserDTO adminUserDTO) {
		this.firstName = adminUserDTO.getFirstName();
		this.lastName = adminUserDTO.getLastName();
		this.username = adminUserDTO.getUsername();
		this.password = adminUserDTO.getPassword();
	}
}
