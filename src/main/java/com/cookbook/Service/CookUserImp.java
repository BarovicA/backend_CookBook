package com.cookbook.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cookbook.entities.CookUser;
import com.cookbook.mappers.CookUserMapper;
import com.cookbook.repositories.CookUserRepository;
import com.cookbook.util.RESTError;

import dtos.CookUserDTO;

public class CookUserImp implements CookUserService {
	
	@Autowired
	CookUserRepository cookUserRepository;
	
	@Autowired
	CookUserMapper cookUserMapper;

	@Override
	public CookUserDTO add(CookUserDTO CookUser) {
		
		return cookUserMapper.toDto(cookUserRepository.save(cookUserMapper.toEntity(CookUser)));
	}

	@Override
	public CookUserDTO modify(Long id, CookUserDTO cook) throws RESTError {
		if (cookUserRepository.existsById(id)) {
		return cookUserMapper.toDto(cookUserRepository.save(cookUserMapper.toEntity(cook)));
		}
		throw new RESTError(1, "Cook not exists");
	}

	@Override
	public CookUser delete(Long id) throws RESTError {
		Optional<CookUser>cook=cookUserRepository.findById(id);
		if(!cook.isEmpty()) {
			cookUserRepository.delete(cook.get());;
		
		return cook.get();
	}
		throw new RESTError(1, "Cook not exists");
	}

}
