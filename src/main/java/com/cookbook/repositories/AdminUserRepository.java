package com.cookbook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookbook.entities.AdminUser;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
	
	 List<AdminUser> findByFirstName(String firstName);
	    List<AdminUser> findByLastName(String lastName);
	    
	    

}
