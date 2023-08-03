package com.cookbook.service;

import com.cookbook.dto.RegularUserDTO;
import com.cookbook.entities.RegularUser;
import com.cookbook.util.RESTError;

public interface RegularUserService {
	
public RegularUserDTO addRegularUser(RegularUserDTO RegularUser);
	
	public RegularUserDTO modifyRegularUser(Long id, RegularUserDTO cook)throws RESTError;
	
	public RegularUser deleteRegularUser(Long id) throws RESTError;

	RegularUserDTO getRegularUserById(Long id);

}
