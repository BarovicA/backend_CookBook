package com.cookbook.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.cookbook.dto.AllergenDTO;
import com.cookbook.entities.Allergen;
import com.cookbook.entities.AllergenRegularUser;
import com.cookbook.util.RESTError;

public interface AllergenService {
	
	public AllergenDTO addAllergen(AllergenDTO allergen);
	
	public AllergenDTO modifyAllergen(Long id,AllergenDTO allergen)throws RESTError;
	
	public Allergen deleteAllergen(Long id)throws RESTError;
	
	public Optional<Allergen> findIngridientById(Long id)throws RESTError;
	
	public List<Allergen>getAllAllergen();
	
	List<Allergen> getByName(String name)throws RESTError;
	
	public Set<Allergen> allergenFromRecipe (Long id)throws RESTError;
	
	public AllergenRegularUser addPersonAllergen(Long regularUserId, Long allergenId)throws RESTError;
	
	public AllergenRegularUser deletePersonAllergen(Long id)throws RESTError;
	
	public Set<Allergen> viewPersonalallergen (Long id) throws RESTError;

}
