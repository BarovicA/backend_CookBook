package com.cookbook.Service;

import com.cookbook.entities.Ingridient;
import com.cookbook.util.RESTError;

import dtos.IngridientDTO;

public interface IngridientService {
	
	public IngridientDTO add(IngridientDTO ingriendient);
	
	public IngridientDTO modify(Long id, IngridientDTO ingridient)throws RESTError;
	
	public Ingridient delete (Long id)throws RESTError;
	
	

}
