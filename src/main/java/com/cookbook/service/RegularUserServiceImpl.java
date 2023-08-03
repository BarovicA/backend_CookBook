package com.cookbook.service;

<<<<<<< Updated upstream

import org.springframework.stereotype.Service;



@Service
public class RegularUserServiceImpl implements RegularUserService {
		
}
=======
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookbook.dto.RegularUserDTO;
import com.cookbook.entities.RegularUser;
import com.cookbook.mappers.RegularUserMapper;
import com.cookbook.repositories.RegularUserRepository;
import com.cookbook.util.RESTError;

@Service
public class RegularUserServiceImpl implements RegularUserService {
	
	 @Autowired
	    private RegularUserMapper regularUserMapper;

	    @Autowired
	    private RegularUserRepository regularUserRepository;

	    @Override
	    public RegularUserDTO addRegularUser(RegularUserDTO regularUserDTO) {
	        RegularUser regularUserEntity = regularUserMapper.toEntity(regularUserDTO);
	        RegularUser savedRegularUserEntity = regularUserRepository.save(regularUserEntity);
	        return regularUserMapper.toDto(savedRegularUserEntity);
	    }

	    @Override
	    public RegularUserDTO modifyRegularUser(Long id, RegularUserDTO regularUserDTO) throws RESTError {
	        if (!regularUserRepository.existsById(id)) {
	            throw new RESTError(1, "Regular user not exists");
	        }

	        RegularUser existingRegularUser = regularUserRepository.findById(id).get();

	        existingRegularUser.setFirstName(regularUserDTO.getFirstName());
	        existingRegularUser.setLastName(regularUserDTO.getLastName());
	        existingRegularUser.setUsername(regularUserDTO.getUsername());
	        existingRegularUser.setPassword(regularUserDTO.getPassword());

	        RegularUser savedRegularUser = regularUserRepository.save(existingRegularUser);
	        return regularUserMapper.toDto(savedRegularUser);
	    }

	    @Override
	    public RegularUserDTO getRegularUserById(Long id) {
	        java.util.Optional<RegularUser> regularUserOptional = regularUserRepository.findById(id);
	        if (regularUserOptional.isEmpty()) {
	            return null;
	        }

	        RegularUser regularUserEntity = regularUserOptional.get();
	        return regularUserMapper.toDto(regularUserEntity);
	    }
	    
	    @Override
	   
	    public RegularUser deleteRegularUser(Long id) throws RESTError {
	        Optional<RegularUser> regularUserOptional = regularUserRepository.findById(id);
	        if (regularUserOptional.isEmpty()) {
	            throw new RESTError(1, "Regular user not found");
	        }
	        RegularUser regularUserEntity = regularUserOptional.get();
	        regularUserEntity.setDeleted(true);
	        regularUserRepository.save(regularUserEntity);

	        return regularUserRepository.save(regularUserEntity);
	    }
	}

	    

>>>>>>> Stashed changes
