package com.cookbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.entities.Allergen;
import com.cookbook.entities.AllergenRegularUser;
import com.cookbook.entities.RegularUser;

public interface AllergenRegularUserRepository extends JpaRepository<AllergenRegularUser, Long> {
	
	boolean existsByAllergenAndRegUser(Allergen allergen,RegularUser regularUser);

}
