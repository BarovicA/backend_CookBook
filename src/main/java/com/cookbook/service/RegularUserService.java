package com.cookbook.service;

import java.util.List;

import com.cookbook.entities.RegularUser;
import com.cookbook.entities.UserRegularRecipe;

public interface RegularUserService {

	RegularUser createNew(RegularUser newUser);

	void delete(Long id);

	RegularUser getById(Long id);

	RegularUser getByUsername(String username);

	RegularUser update(Long id, RegularUser updatedUser);

	List<RegularUser> getAll();

	UserRegularRecipe addRecipeToUser(Long userId, Long recipeId);

}
