package com.cookbook.Service;

import com.cookbook.dto.AllergenDTO;
import com.cookbook.entities.Allergen;
import com.cookbook.util.RESTError;

public interface AllergenService {
	
	public AllergenDTO addAllergen(AllergenDTO allergen);
	
	public AllergenDTO modifyAllergen(Long id,AllergenDTO allergen)throws RESTError;
	
	public Allergen deleteAllergen(Long id)throws RESTError;

}
