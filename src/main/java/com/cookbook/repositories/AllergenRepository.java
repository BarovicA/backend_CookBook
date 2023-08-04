package com.cookbook.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cookbook.entities.Allergen;

@Repository
public interface AllergenRepository extends JpaRepository<Allergen, Long> {
	
	List<Allergen> findByDeletedFalse();
	
	Optional<Allergen> findByDeletedFalseAndName(String name);
	
	List<Allergen> findByDeletedFalseAndNameIgnoreCaseContaining(String name);

}
