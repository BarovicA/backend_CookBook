package com.cookbook.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.entities.RegularUser;

public interface RegularUserRepository extends JpaRepository<RegularUser, Long> {

	Optional<RegularUser> findByDeletedFalseAndUsernameIgnoreCaseContaining(String username);

	List<RegularUser> findByDeletedFalse();

	

	
	
	
}
