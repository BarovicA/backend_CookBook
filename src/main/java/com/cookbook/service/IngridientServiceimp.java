package com.cookbook.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookbook.entities.Ingridient;
import com.cookbook.mappers.IngridientMapper;
import com.cookbook.repositories.AllergenRepository;
import com.cookbook.repositories.IngridientRepository;
import com.cookbook.util.RESTError;

import dtos.IngridientDTO;
@Service
public class IngridientServiceimp implements IngridientService {
	
	@Autowired
	IngridientMapper ingridientMapper;
	@Autowired
	IngridientRepository ingridientRepository;

	@Override
	public IngridientDTO addIngridien(IngridientDTO ingridient) {
		
		ingridient.setDeleted(false);
		return ingridientMapper.toDto(ingridientRepository.save(ingridientMapper.toEntity(ingridient)));
	}

	@Override
	public IngridientDTO modifyIngridien(Long id, IngridientDTO ingridient) throws RESTError {
		if (!ingridientRepository.existsById(id)) {
			throw new RESTError(1, "ingridient not exists");
		}
		Ingridient existingAllergen= ingridientRepository.findById(id).get();
		
		existingAllergen.setName(ingridient.getName());
		existingAllergen.setServingSize(ingridient.getServingSize());
		existingAllergen.setCalories(ingridient.getCalories());
		existingAllergen.setCarbs(ingridient.getCarbs());
		existingAllergen.setSugars(ingridient.getSugars());
		existingAllergen.setFats(ingridient.getFats());
		existingAllergen.setSaturatedFats(ingridient.getSaturatedFats());
		existingAllergen.setProteins(ingridient.getProteins());
		
		Ingridient savedIngridien= ingridientRepository.save(existingAllergen);
		
		return ingridientMapper.toDto(savedIngridien);
	}

	@Override
	public Ingridient deleteIngridien(Long id) throws RESTError {
		Optional<Ingridient> ingridient = ingridientRepository.findById(id);
		if (ingridient.isEmpty()) {
			throw new RESTError(1, "Ingridient not exists");
		}
		Ingridient ingridientEntity = ingridient.get();
		ingridientEntity.setDeleted(true);
		return ingridientRepository.save(ingridientEntity);
		
	}


}
