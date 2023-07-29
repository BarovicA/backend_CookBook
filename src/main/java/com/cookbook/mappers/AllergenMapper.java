package com.cookbook.mappers;

import org.springframework.stereotype.Service;

import com.cookbook.entities.Allergen;

import dtos.AllergenDTO;

@Service
public class AllergenMapper implements GenericMapper<Allergen, AllergenDTO> {

	@Override
	public Allergen toEntity(AllergenDTO dto) {
	
		return new Allergen(dto.getName(),dto.getIcon());
	}

	@Override
	public AllergenDTO toDto(Allergen entity) {
		
		return new AllergenDTO(entity.getName(),entity.getIcon());
	}

}
