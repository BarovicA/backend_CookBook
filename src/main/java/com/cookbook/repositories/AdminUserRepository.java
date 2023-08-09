package com.cookbook.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.entities.AdminUser;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
	
	public Optional<AdminUser> findByUsername(String username);


}
