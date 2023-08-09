package com.cookbook.mappers;

import org.springframework.stereotype.Component;

import com.cookbook.dto.AdminUserDTO;
import com.cookbook.entities.AdminUser;
@Component
public class AdminMapper implements GenericMapper<AdminUser, AdminUserDTO> {

	@Override
	public AdminUser toEntity(AdminUserDTO dto) {
		
		return new AdminUser(dto.getFirstName(),dto.getLastName(),dto.getUsername(),dto.getPassword());
	}

	@Override
	public AdminUserDTO toDto(AdminUser entity) {
		
		return new AdminUserDTO(entity.getFirstName(),entity.getLastName(),entity.getUsername(),entity.getPassword());
	}

}
