package com.cookbook.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookbook.dto.AdminUserDTO;
import com.cookbook.entities.AdminUser;
import com.cookbook.entities.RegularUser;
import com.cookbook.mappers.AdminUserMapper;
import com.cookbook.repositories.AdminUserRepository;
import com.cookbook.util.RESTError;

@Service
public class AdminUserServiceImpl implements AdminUserService{

	
	@Autowired
	AdminUserMapper adminUserMapper;
	@Autowired
	AdminUserRepository adminUserRepository;
	
	@Override
	public AdminUserDTO addAdminUser(AdminUserDTO adminUserDTO) {
        AdminUser adminUserEntity = adminUserMapper.toEntity(adminUserDTO);
        AdminUser savedAdminUserEntity = adminUserRepository.save(adminUserEntity);
        return adminUserMapper.toDto(savedAdminUserEntity);
    }
	@Override
	public AdminUserDTO modifyAdminUser(Long id, AdminUserDTO adminUserDTO) throws RESTError {
		if (!adminUserRepository.existsById(id)) {
	        throw new RESTError(1, "Admin user not exists");
	    }

	    AdminUser existingAdminUser = adminUserRepository.findById(id).get();

	    existingAdminUser.setFirstName(adminUserDTO.getFirstName());
	    existingAdminUser.setLastName(adminUserDTO.getLastName());
	    existingAdminUser.setUsername(adminUserDTO.getUsername());
	    existingAdminUser.setPassword(adminUserDTO.getPassword());


	    AdminUser savedAdminUser = adminUserRepository.save(existingAdminUser);
	    return adminUserMapper.toDto(savedAdminUser);
	}
	
	@Override
	public AdminUserDTO getAdminUserById(Long id) {
	    java.util.Optional<AdminUser> adminUserOptional = adminUserRepository.findById(id);
	    
	    if (adminUserOptional.isEmpty()) {
	       
	        return null;
	    }
	    
	    AdminUser adminUserEntity = adminUserOptional.get();
	    
	    if (adminUserEntity.getDeleted()) {
	    	
	    	return null;
	    }
	    
	    return adminUserMapper.toDto(adminUserEntity);
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
