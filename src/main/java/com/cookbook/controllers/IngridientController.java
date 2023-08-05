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

import com.cookbook.repositories.IngridientRepository;
import com.cookbook.service.IngridientService;
import com.cookbook.util.RESTError;

import com.cookbook.dto.IngridientDTO;
import com.cookbook.entities.Ingridient;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/ingridient")
public class IngridientController {
	
	@Autowired
	IngridientService ingridientService;
	@Autowired
	IngridientRepository ingridientRepository;

	
	private String createErrorMessage(BindingResult result) {
		return result.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(" "));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addIngridient(@Valid @RequestBody IngridientDTO ingridient,BindingResult result)  {
		
		if(result.hasErrors()) {
			return new ResponseEntity<>(createErrorMessage(result),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(ingridientService.addIngridien(ingridient), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<?>modifyIngridient(@PathVariable Long id,@Valid @RequestBody IngridientDTO ingridient, BindingResult result){
		try {
			if(result.hasErrors()) {
				return new ResponseEntity<>(createErrorMessage(result),HttpStatus.BAD_REQUEST);
			}
			ingridientService.modifyIngridien(id, ingridient);
			return new ResponseEntity<>(ingridient,HttpStatus.OK);
		}catch (RESTError e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> removeIngridient(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(ingridientService.deleteIngridien(id));
		} catch (RESTError e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}
	@RequestMapping(method = RequestMethod.GET,value = "/{id}")
	public ResponseEntity<?> findIngridientById(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(ingridientService.findIngridientById(id));
		} catch (RESTError e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Ingridient>getAllIngridient(){
		Iterable<Ingridient>ingridient1= ingridientService.getAllIngridient();
		ArrayList<Ingridient>ingridient2= new ArrayList<>();
		for(Ingridient s: ingridient1) {
			ingridient2.add(s);
		}
		return ingridient2;
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/name/{name}")
	public ResponseEntity<?> findIngridientByName(@PathVariable String name){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(ingridientService.getByName(name));
		} catch (RESTError e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
//	Pretraga svih sastojaka integrisana u pisanje recepta.

	@RequestMapping(method = RequestMethod.GET,value = "/ingridient/Recipe/{id}")
	public ResponseEntity<?> ingridientRecipe(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(ingridientService.ingridientFromRecipe(id));
		} catch (RESTError e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	// add za srednju tabelu IngridientAllergen
	@RequestMapping(method = RequestMethod.POST,value = "/addIngridientAllergen")
	public ResponseEntity<?> ingridientAllergen(@RequestParam Long id_ingridient,@RequestParam Long id_allergen){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(ingridientService.addIngridientAllergen(id_ingridient, id_allergen));
		} catch (RESTError e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	// add za srednju tabelu IngridientRecipe
	@RequestMapping(method = RequestMethod.POST,value = "/addIngridientRecipe")
	public ResponseEntity<?> ingridientRecipe(@RequestParam Long id_ingridient,@RequestParam Long id_recipe,@RequestParam Integer quantity){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(ingridientService.addIngridientRecipe(id_ingridient, id_recipe,quantity));
		} catch (RESTError e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
