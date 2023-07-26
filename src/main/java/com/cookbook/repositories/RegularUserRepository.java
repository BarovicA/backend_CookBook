package com.cookbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.entities.RegularUser;

public interface RegularUserRepository extends JpaRepository<RegularUser, Long> {

}
