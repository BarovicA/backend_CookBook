package com.cookbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cookbook.entities.Allergen;

@Repository
public interface AllergenRepository extends JpaRepository<Allergen, Long> {

}
