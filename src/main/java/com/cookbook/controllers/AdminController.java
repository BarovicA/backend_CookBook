package com.cookbook.controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cookbook.dto.AdminUserDTO;
import com.cookbook.entities.AdminUser;
import com.cookbook.service.AdminService;
import com.cookbook.util.RESTError;

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
		if(result.hasErrors()) {
			return new ResponseEntity<>(createErrorMessage(result),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(adminService.addAdmin(admin), HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<?> modifyAdminUser(@PathVariable Long id, @Valid @RequestBody AdminUser adminUser, BindingResult result)throws RESTError {
		if (result.hasErrors()) {
			return new ResponseEntity<>(createErrorMessage(result), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(adminService.modify(id, adminUser), HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id)throws RESTError {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(adminService.delete(id));
		} catch (RESTError e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
