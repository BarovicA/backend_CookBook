package com.cookbook.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cookbook.entities.Allergen;
import com.cookbook.entities.RegularUser;

@Repository
public interface RegularUserRepository extends JpaRepository<RegularUser, Long> {




	
	
	
}
