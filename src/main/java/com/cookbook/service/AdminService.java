package com.cookbook.service;

import com.cookbook.dto.AdminUserDTO;
import com.cookbook.entities.AdminUser;
import com.cookbook.util.RESTError;

public interface AdminService {
	
	public AdminUserDTO addAdmin(AdminUserDTO admin);
	
	public AdminUserDTO modify (Long id,AdminUser admin)throws RESTError;
	
	public AdminUser delete(Long id)throws RESTError;

}
