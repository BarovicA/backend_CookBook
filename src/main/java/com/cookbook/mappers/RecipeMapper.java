package com.cookbook.mappers;

import com.cookbook.entities.Recipe;

import dtos.ReceptiDTO;

public class RecipeMapper implements GenericMapper<Recipe, ReceptiDTO> {

	@Override
	public Recipe toEntity(ReceptiDTO dto) {
		
		return new Recipe(dto.getName(),dto.getDecription(),dto.getSteps(),dto.getTimeToPrepare(),dto.getExpectedYield());
	
	}
	@Override
	public ReceptiDTO toDto(Recipe entity) {
		
		return new ReceptiDTO(entity.getName(),entity.getDecription(),entity.getSteps(),entity.getTimeToPrepare(),entity.getExpectedYield());
	}

}
