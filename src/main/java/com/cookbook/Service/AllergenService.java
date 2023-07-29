package com.cookbook.Service;

import com.cookbook.entities.Allergen;
import com.cookbook.util.RESTError;

import dtos.AllergenDTO;

public interface AllergenService {
	
	public AllergenDTO addAllergen(AllergenDTO allergen);
	
	public AllergenDTO modifyAllergen(Long id,AllergenDTO allergen)throws RESTError;
	
	public Allergen deleteAllergen(Long id)throws RESTError;

}
