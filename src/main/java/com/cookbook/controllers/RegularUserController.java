package com.cookbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cookbook.dto.RegularUserDTO;
import com.cookbook.entities.RegularUser;
import com.cookbook.repositories.RegularUserRepository;
import com.cookbook.service.RegularUserService;
import com.cookbook.validation.Validation;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/regularuser")
public class RegularUserController {

	 @Autowired
	 RegularUserService regularUserService;
	 
	 @Autowired
	 RegularUserRepository regularUserRepository;
	 
	 @InitBinder
		protected void initBinder(final WebDataBinder binder) {
			binder.addValidators(); 
		}

		// Kreiranje novog korisnika
		@PostMapping("/create")
		@Secured("ADMIN_USER")
		public ResponseEntity<?> addNewUser(@Valid @RequestBody RegularUserDTO newUser, BindingResult result) {
			if (result.hasErrors()) {
				return new ResponseEntity<>(Validation.createErrorMessage(result), HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(regularUserService.createNew(newUser), HttpStatus.OK);
			}
		}

		// Dobijanje svih korisnika
		@GetMapping
		public List<RegularUser> getAllUsers() {
			return regularUserService.getAll();
		}

		// Dobijanje korisnika po ID-u
		@GetMapping("/{id}")
		public RegularUser getUserById(@PathVariable Long id) {
			return regularUserService.getById(id);
		}

		// Dobijanje korisnika po username
		@GetMapping("/username/{username}")
		public RegularUser getUserByUsername(@PathVariable String username) {
			return regularUserService.getByUsername(username);
		}

		// Azuriranje korisnika
		@PutMapping("/{id}")
		@Secured("ADMIN_USER")
		public ResponseEntity<?> updateUser(@PathVariable Long id, @Valid @RequestBody RegularUserDTO updatedUser,  BindingResult result) {
			if (result.hasErrors()) {
				return new ResponseEntity<>(Validation.createErrorMessage(result), HttpStatus.BAD_REQUEST);
			} else {
			return new ResponseEntity<>(regularUserService.update(id, updatedUser), HttpStatus.OK);
			}
		}

		// Brisanje korisnika
		@DeleteMapping("/{id}")
		@Secured("ADMIN_USER")
		public void deleteUser(@PathVariable Long id) {
			regularUserService.delete(id);
		}
		
		// dodavanje u svoju listu recepata
		@PostMapping("/{userId}/recipes/{recipeId}")
		@Secured("REGULAR_USER")
	    public ResponseEntity<?> addRecipeToUser(@PathVariable Long userId, @PathVariable Long recipeId) {
	        regularUserService.addRecipeToUser(userId, recipeId);
	        
	        return new ResponseEntity<>("Recipe " + recipeId + " added for user: " + userId, HttpStatus.OK);
	    }
	}
	 
	
	
