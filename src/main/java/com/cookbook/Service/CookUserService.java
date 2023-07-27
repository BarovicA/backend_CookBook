package com.cookbook.Service;

import com.cookbook.entities.CookUser;
import com.cookbook.util.RESTError;

import dtos.CookUserDTO;

public interface CookUserService {
	
	public CookUserDTO add(CookUserDTO CookUser);
	
	public CookUserDTO modify(Long id, CookUserDTO cook)throws RESTError;
	
	public CookUser delete(Long id) throws RESTError;

}
