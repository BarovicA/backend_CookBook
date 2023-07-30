package com.cookbook.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookbook.entities.Ingridient;
import com.cookbook.mappers.IngridientMapper;
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
		
		return ingridientMapper.toDto(ingridientRepository.save(ingridientMapper.toEntity(ingridient)));
	}

	@Override
	public IngridientDTO modifyIngridien(Long id, IngridientDTO ingridient) throws RESTError {
		if (ingridientRepository.existsById(id)) {
			return ingridientMapper.toDto(ingridientRepository.save(ingridientMapper.toEntity(ingridient)));
		}
		throw new RESTError(1, "ingridient not exists");
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
