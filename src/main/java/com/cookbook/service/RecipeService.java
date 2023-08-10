package com.cookbook.service;

import java.util.List;

import com.cookbook.dto.RecipeDTO;
import com.cookbook.entities.Recipe;

public interface RecipeService {

	public Recipe createNew(Recipe newRecipe);
	List<Recipe> getAll();
    Recipe getById(Long id);
    List<Recipe> getByName(String name);
    Recipe update(Long id, Recipe updatedRecipe);
    void delete(Long id);
	RecipeDTO getByIdDto(long id);
}
