package com.cookbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cookbook.Service.AllergenService;

import dtos.AlergeniDTO;

@RestController
@RequestMapping(path = "/api/v1/allergen")
public class AllergenController {

	@Autowired 
	private AllergenService allergenService;

	@RequestMapping(method = RequestMethod.POST, value = "/addAllergen")
	public ResponseEntity<?> addAllergen(@RequestBody AlergeniDTO allergenDto) {

		var responseDto = allergenService.addAllergen(allergenDto);
		
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

}
