package com.cookbook.service;


import com.cookbook.entities.AdminUser;
import com.cookbook.util.RESTError;

import jakarta.validation.Valid;

public interface AdminUserService {

	public AdminUser addAdminUser(AdminUser AdminUser);

	public AdminUser modifyAdminUser(Long id, AdminUser cook)throws RESTError;
	
	public AdminUser getAdminUserById(Long id);

	public AdminUser deleteAdminUser(Long id)throws RESTError;
}