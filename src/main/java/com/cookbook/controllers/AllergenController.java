package com.cookbook.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.cookbook.service.AllergenService;
import com.cookbook.dto.AllergenDTO;
import com.cookbook.entities.Allergen;
import com.cookbook.repositories.AllergenRepository;
import com.cookbook.util.RESTError;

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
	@RequestMapping(method = RequestMethod.GET,value = "/{id}")
	public ResponseEntity<?> findAllergenById(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(allergenService.findIngridientById(id));
		} catch (RESTError e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Allergen>getAllAllergen(){
		Iterable<Allergen>allergen1= allergenService.getAllAllergen();
		ArrayList<Allergen>allergen2= new ArrayList<>();
		for(Allergen s: allergen1) {
			allergen2.add(s);
		}
		return allergen2;
	}

	@RequestMapping(method = RequestMethod.GET,value = "/name/{name}")
	public ResponseEntity<?> findAllergenByName(@PathVariable String name){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(allergenService.getByName(name));
		} catch (RESTError e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
//	Prikaz dinamički sračunatih podataka o alergenima/OF kod prikaza i pretraga receptima. 

	@RequestMapping(method = RequestMethod.GET,value = "/allergenRecipe/{id}")
	public ResponseEntity<?>allergenInRecipe(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(allergenService.allergenFromRecipe(id));
		} catch (RESTError e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
//	Dodavanje ličnih alergena/ograničavajućih faktora (OF)

	@RequestMapping(method = RequestMethod.POST,value = "/personalAllergen")
	public ResponseEntity<?>addPersonAllergen(@RequestParam Long allergenId,@RequestParam Long regularId ){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(allergenService.addPersonAllergen(allergenId,regularId));
		} catch (RESTError e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
//	Brisanje ličnih alergena/OF
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/deletePersonalAllergen/{id}")
	public ResponseEntity<?>deletePersonAllergen(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(allergenService.deletePersonAllergen(id));
		} catch (RESTError e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
//	Prikaz liste ličnih alergena/OF
	@RequestMapping(method = RequestMethod.GET,value = "/PersonalAllergen/{id}")
	public ResponseEntity<?>viewersonAllergen(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(allergenService.viewPersonalallergen(id));
		} catch (RESTError e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
