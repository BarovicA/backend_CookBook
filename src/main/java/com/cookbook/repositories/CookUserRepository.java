package com.cookbook.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.entities.CookUser;

public interface CookUserRepository extends JpaRepository<CookUser, Long> {

	Optional<CookUser> findByDeletedFalseAndUsernameIgnoreCaseContaining(String username);

}
