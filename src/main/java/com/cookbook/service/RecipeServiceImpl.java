package com.cookbook.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cookbook.entities.Recipe;
import com.cookbook.exceptions.ResourceNotFoundException;
import com.cookbook.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {
	
	@Autowired
	RecipeRepository recipeRepository;
	
	@Override
	public Recipe createNew(Recipe newRecipe) {
		Recipe recipe = new Recipe();
		recipe.setName(newRecipe.getName());
		recipe.setDecription(newRecipe.getDecription());
		recipe.setSteps(newRecipe.getSteps());
		recipe.setTimeToPrepare(newRecipe.getTimeToPrepare());
		recipe.setExpectedYield(newRecipe.getExpectedYield());
		recipe.setDeleted(false);
		return recipeRepository.save(recipe);
	}

	@Override
	public List<Recipe> getAll() {
		 return recipeRepository.findByDeletedFalse();
    }

	@Override
	public Recipe getById(Long id) {
		return recipeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recipe", "id", id));
    }

	@Override
	public List<Recipe> getByName(String name) {
	    List<Recipe> recipes = recipeRepository.findByDeletedFalseAndNameIgnoreCaseContaining(name);
	    if (recipes.isEmpty()) {
	        throw new ResourceNotFoundException("Recipe", "name", name);
	    }
	    return recipes;
	}   

	@Override
	public Recipe update(Long id, Recipe updatedRecipe) {
		return recipeRepository.findById(id).map(recipe -> {
            recipe.setName(updatedRecipe.getName());
            recipe.setDecription(updatedRecipe.getDecription());
            recipe.setSteps(updatedRecipe.getSteps());
            recipe.setTimeToPrepare(updatedRecipe.getTimeToPrepare());
            recipe.setExpectedYield(updatedRecipe.getExpectedYield());
            return recipeRepository.save(recipe);
        }).orElseThrow(() -> new ResourceNotFoundException("Recipe", "id", id));
    }

	@Override
	public void delete(Long id) {
		Recipe recipe = getById(id);
        recipe.setDeleted(true);
        recipeRepository.save(recipe);
    }
}
