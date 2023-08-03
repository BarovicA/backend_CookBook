package com.cookbook.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookbook.dto.CookUserDTO;
import com.cookbook.entities.CookUser;
import com.cookbook.mappers.CookUserMapper;
import com.cookbook.repositories.CookUserRepository;
import com.cookbook.util.RESTError;
@Service
public class CookUserImp implements CookUserService {
	
	@Autowired
	CookUserRepository cookUserRepository;
	
	@Autowired
	CookUserMapper cookUserMapper;

	@Override
	public CookUserDTO addCook(CookUserDTO CookUser) {
		
		return cookUserMapper.toDto(cookUserRepository.save(cookUserMapper.toEntity(CookUser)));
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
		existingCook.setPassword(cook.getPassword());
		
		
		
		CookUser savedCook= cookUserRepository.save(existingCook);
		return cookUserMapper.toDto(savedCook);
	}

	@Override
	public CookUser deleteCook(Long id) throws RESTError {
		Optional<CookUser>cook=cookUserRepository.findById(id);
		if(cook .isEmpty()) {
			throw new RESTError(1, "Cook not exists");
		}	
		CookUser cookEntity = cook.get();
		cookEntity.setDeleted(true);
		return cookUserRepository.save(cookEntity);
		
	}

}
