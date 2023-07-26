package com.cookbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
