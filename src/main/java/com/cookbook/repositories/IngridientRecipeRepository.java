package com.cookbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.entities.IngridientRecipe;

public interface IngridientRecipeRepository extends JpaRepository<IngridientRecipe, Long>{

}