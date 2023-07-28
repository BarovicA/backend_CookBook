package com.cookbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.entities.Allergen;

public interface AllergenRepository extends JpaRepository<Allergen, Long> {

}
