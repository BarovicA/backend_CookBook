package com.cookbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.entities.CookUser;

public interface CookUserRepository extends JpaRepository<CookUser, Long> {

}
