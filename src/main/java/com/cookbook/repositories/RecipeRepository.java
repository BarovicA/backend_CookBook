package com.cookbook.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
	
	
	List<Recipe> findByDeletedFalse();

	Optional<Recipe> findByDeletedFalseAndName(String name);
	
	List<Recipe> findByDeletedFalseAndNameIgnoreCaseContaining(String name);

}
