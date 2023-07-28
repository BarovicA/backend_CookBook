package com.cookbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.entities.Ingridient;

public interface IngridientRepository extends JpaRepository<Ingridient, Long> {

}
