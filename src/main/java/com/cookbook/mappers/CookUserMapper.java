package com.cookbook.mappers;

import org.springframework.stereotype.Component;

import com.cookbook.dto.CookUserDTO;
import com.cookbook.entities.CookUser;

@Component
public class CookUserMapper implements GenericMapper<CookUser, CookUserDTO> {

	@Override
	public CookUser toEntity(CookUserDTO dto) {

		return new CookUser(dto);
	}

	@Override
	public CookUserDTO toDto(CookUser entity) {

		return new CookUserDTO(entity);
	}

}
