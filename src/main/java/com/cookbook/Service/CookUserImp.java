package com.cookbook.Service;

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
	public CookUserDTO addCook(CookUserDTO CookUser) {
		
		return cookUserMapper.toDto(cookUserRepository.save(cookUserMapper.toEntity(CookUser)));
	}

	@Override
	public CookUserDTO modifyCook(Long id, CookUserDTO cook) throws RESTError {
		if (cookUserRepository.existsById(id)) {
		return cookUserMapper.toDto(cookUserRepository.save(cookUserMapper.toEntity(cook)));
		}
		throw new RESTError(1, "Cook not exists");
	}

	@Override
	public CookUser deleteCook(Long id) throws RESTError {
		Optional<CookUser>cook=cookUserRepository.findById(id);
		if(cook.isEmpty()) {
			throw new RESTError(1, "Cook not exists");
		}	
		CookUser cookEntity = cook.get();
		cookEntity.setDeleted(true);
		return cookEntity;
		
	}

}
