package com.cookbook.Service;

import com.cookbook.entities.CookUser;
import com.cookbook.util.RESTError;

import dtos.CookUserDTO;

public interface CookUserService {
	
	public CookUserDTO addCook(CookUserDTO CookUser);
	
	public CookUserDTO modifyCook(Long id, CookUserDTO cook)throws RESTError;
	
	public CookUser deleteCook(Long id) throws RESTError;

}
