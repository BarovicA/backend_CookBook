package com.cookbook.mappers;

import com.cookbook.entities.Recipe;

import dtos.RecipeDTO;

public class RecipeMapper implements GenericMapper<Recipe, RecipeDTO> {

	@Override
	public Recipe toEntity(RecipeDTO dto) {
		
		return new Recipe(dto.getName(),dto.getDecription(),dto.getSteps(),dto.getTimeToPrepare(),dto.getExpectedYield());
	
	}
	@Override
	public RecipeDTO toDto(Recipe entity) {
		
		return new RecipeDTO(entity.getName(),entity.getDecription(),entity.getSteps(),entity.getTimeToPrepare(),entity.getExpectedYield());
	}

}
