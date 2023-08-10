package com.cookbook.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cookbook.entities.CookUser;

public interface CookUserRepository extends JpaRepository<CookUser, Long> {

	Optional<CookUser> findByDeletedFalseAndUsernameIgnoreCaseContaining(String username);

	List<CookUser> findByDeletedFalse();
	
//	@Query("SELECT cu FROM CookUser cu WHERE cu.deleted = false")
//    List<CookUser> findNotDeleted();
}


