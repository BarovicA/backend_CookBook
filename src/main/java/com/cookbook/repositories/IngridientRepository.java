package com.cookbook.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.entities.Ingridient;

public interface IngridientRepository extends JpaRepository<Ingridient, Long> {
	
	List<Ingridient> findByDeletedFalse();
	
	Optional<Ingridient> findByDeletedFalseAndName(String name);
	
	List<Ingridient> findByDeletedFalseAndNameIgnoreCaseContaining(String name);

}
