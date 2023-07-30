package com.cookbook.mappers;

import org.springframework.stereotype.Component;

import com.cookbook.dto.CookUserDTO;
import com.cookbook.entities.CookUser;
@Component
public class CookUserMapper implements GenericMapper<CookUser, CookUserDTO> {

	@Override
	public CookUser toEntity(CookUserDTO dto) {
		// TODO Auto-generated method stub
		return new CookUser(dto.getFirstName(),dto.getLastName(),dto.getUsername(),dto.getPassword());
	}

	@Override
	public CookUserDTO toDto(CookUser entity) {
		// TODO Auto-generated method stub
		return new CookUserDTO(entity.getFirstName(),entity.getLastName(),entity.getUsername(),entity.getPassword());
	}

}
