package com.cookbook.service;

import com.cookbook.dto.CookUserDTO;
import com.cookbook.entities.CookUser;
import com.cookbook.util.RESTError;

public interface CookUserService {
	
	public CookUserDTO addCook(CookUserDTO CookUser) throws RESTError;
	
	public CookUserDTO modifyCook(Long id, CookUserDTO cook)throws RESTError;
	
	public CookUser deleteCook(Long id) throws RESTError;

}
