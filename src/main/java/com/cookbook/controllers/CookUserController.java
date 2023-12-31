package com.cookbook.controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cookbook.dto.CookUserDTO;
import com.cookbook.repositories.CookUserRepository;
import com.cookbook.service.CookUserService;
import com.cookbook.util.RESTError;

import jakarta.validation.Valid;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api/v1/cookUser")
public class CookUserController {
	
	@Autowired
	CookUserService cookUserService;
	@Autowired
	CookUserRepository cookUserRepository;
	
	private String createErrorMessage(BindingResult result) {
		return result.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(" "));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@Secured("ADMIN_USER")
	public ResponseEntity<?> addCook(@Valid @RequestBody CookUserDTO cook,BindingResult result) throws RESTError  {
		
		if(result.hasErrors()) {
			return new ResponseEntity<>(createErrorMessage(result),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(cookUserService.addCook(cook), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	@Secured("ADMIN_USER")
	public ResponseEntity<?>modifyCook(@PathVariable Long id,@Valid @RequestBody CookUserDTO cook, BindingResult result){
		try {
			if(result.hasErrors()) {
				return new ResponseEntity<>(createErrorMessage(result),HttpStatus.BAD_REQUEST);
			}
			cookUserService.modifyCook(id, cook);
			return new ResponseEntity<>(cook,HttpStatus.OK);
		}catch (RESTError e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
		
		@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
		@Secured("ADMIN_USER")
		public ResponseEntity<?> deleteCook(@PathVariable Long id) {

			try {
				cookUserService.deleteCook(id);
				return ResponseEntity.ok(" user deleted successfully");
				//return ResponseEntity.status(HttpStatus.OK).body(cookUserService.deleteCook(id));
			} catch (RESTError e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			}
	}

}