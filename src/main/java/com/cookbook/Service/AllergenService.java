package com.cookbook.Service;

import com.cookbook.entities.Allergen;
import com.cookbook.util.RESTError;

import dtos.AlergeniDTO;

public interface AllergenService {
	
	public AlergeniDTO addAllergen(AlergeniDTO allergen);
	
	public AlergeniDTO modifyAllergen(Long id,AlergeniDTO allergen)throws RESTError;
	
	public Allergen deleteAllergen(Long id)throws RESTError;

}
