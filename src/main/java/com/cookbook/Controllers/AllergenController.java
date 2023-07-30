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

import com.cookbook.Service.AllergenService;
import com.cookbook.repositories.AllergenRepository;
import com.cookbook.util.RESTError;

import dtos.AllergenDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/allergen")
public class AllergenController {
	
	@Autowired
	AllergenService allergenService;
	@Autowired
	AllergenRepository allergenRepository;
	
	private String createErrorMessage(BindingResult result) {
		return result.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(" "));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addAllergen(@Valid @RequestBody AllergenDTO allergen,BindingResult result)  {
		
		if(result.hasErrors()) {
			return new ResponseEntity<>(createErrorMessage(result),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(allergenService.addAllergen(allergen), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<?>modifyAllergen(@PathVariable Long id,@Valid @RequestBody AllergenDTO allergen, BindingResult result){
		try {
			if(result.hasErrors()) {
				return new ResponseEntity<>(createErrorMessage(result),HttpStatus.BAD_REQUEST);
			}
			allergenService.modifyAllergen(id, allergen);
			return new ResponseEntity<>(allergen,HttpStatus.OK);
		}catch (RESTError e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> removeAllergen(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(allergenService.deleteAllergen(id));
		} catch (RESTError e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}

}