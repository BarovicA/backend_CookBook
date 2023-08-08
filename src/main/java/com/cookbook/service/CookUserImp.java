package com.cookbook.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookbook.dto.CookUserDTO;
import com.cookbook.entities.CookUser;
import com.cookbook.entities.Role;
import com.cookbook.entities.enums.RoleENUM;
import com.cookbook.mappers.CookUserMapper;
import com.cookbook.repositories.CookUserRepository;
import com.cookbook.repositories.RoleRepository;
import com.cookbook.util.Encryption;
import com.cookbook.util.RESTError;
@Service
public class CookUserImp implements CookUserService {
	
	@Autowired
	CookUserRepository cookUserRepository;
	
	@Autowired
	CookUserMapper cookUserMapper;
	@Autowired
	RoleRepository roleRepository;

	@Override
	public CookUserDTO addCook(CookUserDTO CookUser) throws RESTError {
		CookUser c = new CookUser();
		Role r=roleRepository.findByName(RoleENUM.COOK_USER);
		 if(r == null) {
		        throw new RESTError(1,"Role does not exist in the database");
		 }
		c.setFirstName(CookUser.getFirstName());
		c.setLastName(CookUser.getLastName());
		c.setUsername(CookUser.getUsername());
		c.setPassword(Encryption.getPassEncoded(CookUser.getPassword()));
		c.setRole(r);
		return cookUserMapper.toDto(cookUserRepository.save(c));
	}

	@Override
	public CookUserDTO modifyCook(Long id, CookUserDTO cook) throws RESTError {
		if (!cookUserRepository.existsById(id)) {
		throw new RESTError(1, "Cook not exists");
		}
		CookUser existingCook= cookUserRepository.findById(id).get();
		
		existingCook.setFirstName(cook.getFirstName());
		existingCook.setLastName(cook.getLastName());
		existingCook.setUsername(cook.getUsername());
		existingCook.setPassword(Encryption.getPassEncoded(cook.getPassword()));
		
		
		
		CookUser savedCook= cookUserRepository.save(existingCook);
		return cookUserMapper.toDto(savedCook);
	}

	@Override
	public CookUser deleteCook(Long id) throws RESTError {
		Optional<CookUser>cook=cookUserRepository.findById(id);
		if(cook.isEmpty()) {
			throw new RESTError(1, "Cook not exists");
		}	
		CookUser cookEntity = cook.get();
		cookEntity.setDeleted(true);
		return cookUserRepository.save(cookEntity);
		
	}

}
