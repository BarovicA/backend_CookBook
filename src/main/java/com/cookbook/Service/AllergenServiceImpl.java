package com.cookbook.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookbook.entities.Allergen;
import com.cookbook.mappers.AllergenMapper;
import com.cookbook.repositories.AllergenRepository;
import com.cookbook.util.RESTError;

import dtos.AllergenDTO;

@Service
public class AllergenServiceImpl implements AllergenService {
	
	@Autowired
	AllergenMapper allergenMapper;
	@Autowired
	AllergenRepository allergenRepository;

	@Override
	public AllergenDTO addAllergen(AllergenDTO allergen) {
		
		allergen.setDeleted(false);
		return allergenMapper.toDto(allergenRepository.save(allergenMapper.toEntity(allergen)));
		
	}

	@Override

	public AllergenDTO modifyAllergen(Long id, AllergenDTO allergenDTO) throws RESTError {
	    if (!allergenRepository.existsById(id)) {
	        throw new RESTError(1, "Allergen with the given id does not exist.");
	    }
	   	  
	    Allergen existingAllergen = allergenRepository.findById(id).get();
	    
	    existingAllergen.setName(allergenDTO.getName());
	    existingAllergen.setIcon(allergenDTO.getIcon());
	    existingAllergen.setDeleted(allergenDTO.getDeleted());
	   
	    Allergen savedAllergen = allergenRepository.save(existingAllergen);
	 
	    return allergenMapper.toDto(savedAllergen);
	}


	@Override
	public Allergen deleteAllergen(Long id) throws RESTError {
		
		Optional<Allergen> allergen = allergenRepository.findById(id);
		if (allergen.isEmpty()) {
			throw new RESTError(1, "allergen not exists");
		}
		Allergen allergenEntity = allergen.get();
		allergenEntity.setDeleted(true);
		return allergenRepository.save(allergenEntity);
	}

}
