package com.cookbook.mappers;

import org.springframework.stereotype.Component;

import com.cookbook.entities.Allergen;

import dtos.AllergenDTO;

@Component
public class AllergenMapper implements GenericMapper<Allergen, AllergenDTO> {

	@Override
	public Allergen toEntity(AllergenDTO dto) {
	
		return new Allergen(dto.getName(),dto.getIcon(),dto.getDeleted());
	}

	@Override
	public AllergenDTO toDto(Allergen entity) {
		
		return new AllergenDTO(entity.getName(),entity.getIcon(),entity.getDeleted());
	}

}
