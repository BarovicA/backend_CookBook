package com.cookbook.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cookbook.entities.Ingridient;
import com.cookbook.mappers.IngridientMapper;
import com.cookbook.repositories.IngridientRepository;
import com.cookbook.util.RESTError;

import dtos.IngridientDTO;

public class IngridientServiceimp implements IngridientService {
	
	@Autowired
	IngridientMapper ingridientMapper;
	@Autowired
	IngridientRepository ingridientRepository;

	@Override
	public IngridientDTO add(IngridientDTO ingridient) {
		
		return ingridientMapper.toDto(ingridientRepository.save(ingridientMapper.toEntity(ingridient)));
	}

	@Override
	public IngridientDTO modify(Long id, IngridientDTO ingridient) throws RESTError {
		if (ingridientRepository.existsById(id)) {
			return ingridientMapper.toDto(ingridientRepository.save(ingridientMapper.toEntity(ingridient)));
		}
		throw new RESTError(1, "ingridient not exists");
	}

	@Override
	public Ingridient delete(Long id) throws RESTError {
		Optional<Ingridient> classEntity = ingridientRepository.findById(id);
		if (!classEntity.isEmpty()) {
			ingridientRepository.delete(classEntity.get());
			return classEntity.get();
		}

		throw new RESTError(1, "Ingridient not exists");
	}


}
