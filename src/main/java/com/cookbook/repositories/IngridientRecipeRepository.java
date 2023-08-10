package com.cookbook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.entities.IngridientRecipe;
import com.cookbook.entities.Recipe;

public interface IngridientRecipeRepository extends JpaRepository<IngridientRecipe, Long>{
	
	List<IngridientRecipe> findByRecipeAndDeletedFalse(Recipe recipe);

}
