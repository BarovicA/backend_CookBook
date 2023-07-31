package com.cookbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cookbook.repositories.RegularUserRepository;
import com.cookbook.service.RegularUserService;

@RestController
@RequestMapping(path = "/api/v1/regularuser")
public class RegularUserController {

	 @Autowired
	 RegularUserService regularUserService;
	 
	 @Autowired
	 RegularUserRepository regularUserRepository;
	 
	 
	 
	
	
}
