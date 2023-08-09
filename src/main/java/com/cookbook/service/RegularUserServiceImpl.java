package com.cookbook.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookbook.dto.RegularUserDTO;
import com.cookbook.entities.Recipe;
import com.cookbook.entities.RegularUser;
import com.cookbook.entities.Role;
import com.cookbook.entities.UserRegularRecipe;
import com.cookbook.entities.enums.RoleENUM;
import com.cookbook.exceptions.ResourceNotFoundException;
import com.cookbook.repositories.RecipeRepository;
import com.cookbook.repositories.RegularUserRepository;
import com.cookbook.repositories.RoleRepository;
import com.cookbook.repositories.UserRegularRecipeRepository;
import com.cookbook.util.Encryption;

@Service
public class RegularUserServiceImpl implements RegularUserService {

	@Autowired
    RegularUserRepository userRepository; 
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	RecipeRepository recipeRepository;
	
	@Autowired
	UserRegularRecipeRepository userRegularRecipeRepository;
	
	@Override
	public RegularUser createNew(RegularUserDTO newUser) {
		
	    RegularUser user = new RegularUser();
	    user.setFirstName(newUser.getFirstName());
	    user.setLastName(newUser.getLastName());
	    user.setUsername(newUser.getUsername());
	    user.setPassword(Encryption.getPassEncoded(newUser.getPassword()));
	    // preuzimanje Role
	    Role role = roleRepository.findByName(RoleENUM.REGULAR_USER);
	    if(role == null) {
	        throw new IllegalArgumentException("Role does not exist in the database");
	    }

	    user.setRole(role);
	    user.setDeleted(false);
	    return userRepository.save(user);
	}
	
	@Override
    public List<RegularUser> getAll() {
        return userRepository.findByDeletedFalse();
    }
	@Override
    public RegularUser getById(Long id) {
        return userRepository.findById(id).orElse(null); 
    }
	@Override
    public RegularUser getByUsername(String username) {
        return userRepository.findByDeletedFalseAndUsernameIgnoreCaseContaining(username).orElse(null); 
    }
	@Override
    public RegularUser update(Long id, RegularUserDTO updatedUser) {
        RegularUser existingUser = getById(id);
        if (existingUser != null) {
            
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(Encryption.getPassEncoded(updatedUser.getPassword()));
            // ...
            return userRepository.save(existingUser);
        } else {
            
            return null;
        }
    }
	
	@Override
	public void delete(Long id) {
	    RegularUser existingUser = getById(id);
	    if (existingUser != null) {
	        existingUser.setDeleted(true);
	        userRepository.save(existingUser);
	    } else {
	        throw new IllegalArgumentException("User with id " + id + " does not exist");
	    }
	}
	
	@Override
	public UserRegularRecipe addRecipeToUser(Long userId, Long recipeId) {
		
        // Pronalazimo korisnika i recept u bazi podataka
		RegularUser user = userRepository.findById(userId)
			    .orElseThrow(() -> { throw new ResourceNotFoundException("User", "id ", userId); });
        Recipe recipe = recipeRepository.findById(recipeId)
        		.orElseThrow(() -> {throw new ResourceNotFoundException("Recipe", "id ", recipeId); });
        
        //  novi UserRegularRecipe
        UserRegularRecipe userRecipe = new UserRegularRecipe();
        userRecipe.setUser(user);
        userRecipe.setRecipe(recipe);
        
        
        return userRegularRecipeRepository.save(userRecipe);
    }
	
	
}
		

