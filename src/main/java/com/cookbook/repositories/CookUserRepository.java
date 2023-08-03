package com.cookbook.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cookbook.entities.CookUser;

@Repository
public interface CookUserRepository extends JpaRepository<CookUser, Long> {
	
	 List<CookUser> findByDeletedFalse();

	    Optional<CookUser> findByDeletedFalseAndUsername(String username);

	    List<CookUser> findByDeletedFalseAndUsernameIgnoreCaseContaining(String username);
	}


