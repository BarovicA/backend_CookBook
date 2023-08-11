package com.cookbook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.entities.Recipe;
import com.cookbook.entities.RegularUser;
import com.cookbook.entities.UserRegularRecipe;

public interface UserRegularRecipeRepository extends JpaRepository<UserRegularRecipe, Long>{

	

	//List<UserRegularRecipe> findAllByRegularUserAndDeletetFalse(RegularUser user);

	UserRegularRecipe findByUserAndRecipe(RegularUser user, Recipe recipe);

	List<UserRegularRecipe> findAllByUser(RegularUser user);

	
}
