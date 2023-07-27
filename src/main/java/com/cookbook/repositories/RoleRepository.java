package com.cookbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
