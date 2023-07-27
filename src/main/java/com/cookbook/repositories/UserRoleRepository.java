package com.cookbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.entities.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
