package com.cookbook.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookbook.entities.RegularUser;
import com.cookbook.entities.Role;
import com.cookbook.entities.enums.RoleENUM;
import com.cookbook.repositories.RegularUserRepository;
import com.cookbook.repositories.RoleRepository;

@Service
public class RegularUserServiceImpl implements RegularUserService {

	@Autowired
    RegularUserRepository userRepository; 
	
	@Autowired
	RoleRepository roleRepository;
	

	@Override
	public RegularUser createNew(RegularUser newUser) {
		
	    RegularUser user = new RegularUser();
	    user.setFirstName(newUser.getFirstName());
	    user.setLastName(newUser.getLastName());
	    user.setUsername(newUser.getUsername());
	    user.setPassword(newUser.getPassword());
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
        return userRepository.findAll();
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
    public RegularUser update(Long id, RegularUser updatedUser) {
        RegularUser existingUser = getById(id);
        if (existingUser != null) {
            
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());
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
}
		

