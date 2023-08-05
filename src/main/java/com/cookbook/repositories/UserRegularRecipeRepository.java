package com.cookbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.entities.UserRegularRecipe;

public interface UserRegularRecipeRepository extends JpaRepository<UserRegularRecipe, Long>{

	
}
