package com.cookbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.entities.AdminUser;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {

}
