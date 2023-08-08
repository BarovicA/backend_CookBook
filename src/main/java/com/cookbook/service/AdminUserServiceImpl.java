package com.cookbook.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookbook.entities.AdminUser;
import com.cookbook.entities.RegularUser;
import com.cookbook.entities.Role;
import com.cookbook.entities.enums.RoleENUM;
import com.cookbook.repositories.AdminUserRepository;
import com.cookbook.repositories.RegularUserRepository;
import com.cookbook.repositories.RoleRepository;
import com.cookbook.util.RESTError;

@Service
public class AdminUserServiceImpl implements AdminUserService{

	
	@Autowired
    AdminUserRepository adminUserRepository; 
	
	@Autowired
	RoleRepository roleRepository;
	
	
	@Override
	public AdminUser addAdminUser(AdminUser newUser) {
        AdminUser user = new AdminUser();
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());
        
        Role role = roleRepository.findByName(RoleENUM.ADMIN_USER);
        
        user.setRole(role);
        user.setDeleted(false);
        return adminUserRepository.save(user);        
    }
	
	
	@Override
	public AdminUser modifyAdminUser(Long id, AdminUser adminUser) throws RESTError {
		if (!adminUserRepository.existsById(id)) {
	        throw new RESTError(1, "Admin user not exists");
	    }

	    AdminUser existingAdminUser = adminUserRepository.findById(id).get();

	    existingAdminUser.setFirstName(adminUser.getFirstName());
	    existingAdminUser.setLastName(adminUser.getLastName());
	    existingAdminUser.setUsername(adminUser.getUsername());
	    existingAdminUser.setPassword(adminUser.getPassword());


	    return adminUserRepository.save(existingAdminUser);
	}
	
	
	
	@Override
	public AdminUser getAdminUserById(Long id) {
  
	    return adminUserRepository.findById(id).orElse(null);
	}
	
	
	
	@Override
	public AdminUser deleteAdminUser(Long id) throws RESTError {
		 Optional<AdminUser> adminUserOptional = adminUserRepository.findById(id);
	        if (adminUserOptional.isEmpty()) {
	            throw new RESTError(1, "Admin user not found");
	        }
	        AdminUser adminUserEntity = adminUserOptional.get();
	        adminUserEntity.setDeleted(true);
	        adminUserRepository.save(adminUserEntity);

	        return adminUserRepository.save(adminUserEntity);
	    }
	
	
}
