package com.cookbook.mappers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cookbook.dto.AdminUserDTO;
import com.cookbook.entities.AdminUser;

@Component
@Service

public class AdminUserMapper implements GenericMapper<AdminUser, AdminUserDTO> {

  


	  @Override
	    public AdminUser toEntity(AdminUserDTO dto) {
		  return new AdminUser(dto);
	    }


	  @Override
	    public AdminUserDTO toDto(AdminUser entity) {
	        return new AdminUserDTO(entity);
	    }
	}
