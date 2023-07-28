package com.cookbook.mappers;

import com.cookbook.entities.Ingridient;

import dtos.IngridientDTO;

public class IngridientMapper implements GenericMapper<Ingridient, IngridientDTO> {

	@Override
	public Ingridient toEntity(IngridientDTO dto) {
	
		return new Ingridient (dto.getName(),dto.getServingSize(),dto.getCalories(),dto.getCarbs(),dto.getSugars(),dto.getFats(),dto.getSaturatedFats(),dto.getProteins());
	}

	@Override
	public IngridientDTO toDto(Ingridient entity) {	
		return new IngridientDTO(entity.getName(),entity.getServingSize(),entity.getCalories(),entity.getCarbs(),entity.getSugars(),entity.getFats(),entity.getSaturatedFats(),entity.getProteins());
	}

}
