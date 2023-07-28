package com.cookbook.Service;

import com.cookbook.entities.Ingridient;
import com.cookbook.util.RESTError;

import dtos.IngridientDTO;

public interface IngridientService {
	
	public IngridientDTO addIngridien(IngridientDTO ingriendient);
	
	public IngridientDTO modifyIngridien(Long id, IngridientDTO ingridient)throws RESTError;
	
	public Ingridient deleteIngridien (Long id)throws RESTError;
	
	

}
