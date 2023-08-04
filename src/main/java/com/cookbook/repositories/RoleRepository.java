package com.cookbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.entities.Role;
import com.cookbook.entities.enums.RoleENUM;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(RoleENUM regularUser);

}
