package com.cookbook.controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cookbook.dto.AdminUserDTO;
import com.cookbook.service.AdminService;

import jakarta.validation.Valid;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/api/v1/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	private String createErrorMessage(BindingResult result) {
		return result.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(" "));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addAdmin(@Valid @RequestBody AdminUserDTO admin,BindingResult result)  {
		System.out.println(admin.getFirstName()+" "+ admin.getLastName()+" "+  admin.getUsername()+" "+  admin.getPassword());
		if(result.hasErrors()) {
			return new ResponseEntity<>(createErrorMessage(result),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(adminService.addAdmin(admin), HttpStatus.OK);
	}

}
