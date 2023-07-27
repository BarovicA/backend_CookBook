package com.cookbook.mappers;

public interface GenericMapper <E,D> {
	
	E toEntity(D dto);
	D toDto(E entity);

}
