package com.cookbook.Controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cookbook.Service.CookUserService;
import com.cookbook.repositories.CookUserRepository;
import com.cookbook.util.RESTError;

import dtos.CookUserDTO;
import jakarta.validation.Valid;

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
	public ResponseEntity<?> addCook(@Valid @RequestBody CookUserDTO cook,BindingResult result) throws RESTError  {
		
		if(result.hasErrors()) {
			return new ResponseEntity<>(createErrorMessage(result),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(cookUserService.addCook(cook), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
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
		public ResponseEntity<?> removeCook(@PathVariable Long id) {
			try {
				return ResponseEntity.status(HttpStatus.OK).body(cookUserService.deleteCook(id));
			} catch (RESTError e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			}
	}

}
