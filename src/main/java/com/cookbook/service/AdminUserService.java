package com.cookbook.service;

import com.cookbook.dto.AdminUserDTO;
import com.cookbook.entities.AdminUser;
import com.cookbook.util.RESTError;

import jakarta.validation.Valid;

public interface AdminUserService {

	public AdminUserDTO addAdminUser(AdminUserDTO AdminUser);

	public AdminUserDTO modifyAdminUser(Long id, AdminUserDTO cook)throws RESTError;
	
	public AdminUserDTO getAdminUserById(Long id);

	public AdminUser deleteAdminUser(Long id)throws RESTError;
}

