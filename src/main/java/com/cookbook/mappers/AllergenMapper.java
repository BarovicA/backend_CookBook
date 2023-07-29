package com.cookbook.mappers;

import org.springframework.stereotype.Service;

import com.cookbook.entities.Allergen;

import dtos.AlergeniDTO;

@Service
public class AllergenMapper implements GenericMapper<Allergen, AlergeniDTO> {

	@Override
	public Allergen toEntity(AlergeniDTO dto) {
	
		return new Allergen(dto.getName(),dto.getIcon());
	}

	@Override
	public AlergeniDTO toDto(Allergen entity) {
		
		return new AlergeniDTO(entity.getName(),entity.getIcon());
	}

}
