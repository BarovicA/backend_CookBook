package com.cookbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.cookbook.Service.RecipeService;
import com.cookbook.entities.Recipe;
import com.cookbook.validation.Validation;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {

	@Autowired
	RecipeService recipeService;

	@InitBinder
	protected void initBinder(final WebDataBinder binder) {
		binder.addValidators();
	}

	// Kreiranje novog recepta
	@PostMapping("/create")
	public ResponseEntity<?> addNewRecipe(@Valid @RequestBody Recipe newSubject, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(Validation.createErrorMessage(result), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(recipeService.createNew(newSubject), HttpStatus.OK);
		}
	}

	// Dobijanje svih recepata
	@GetMapping
	public List<Recipe> getAllRecipes() {
		return recipeService.getAll();
	}

	// Dobijanje recepta po ID-u
	@GetMapping("/{id}")
	public Recipe getRecipeById(@PathVariable Long id) {
		return recipeService.getById(id);
	}

	// Dobijanje recepta po imenu
	@GetMapping("/name/{name}")
	public Recipe getRecipeByName(@PathVariable String name) {
		return recipeService.getByName(name);
	}

	// Azuriranje recepta
	@PutMapping("/{id}")
	public Recipe updateRecipe(@PathVariable Long id, @Valid @RequestBody Recipe updatedRecipe) {
		return recipeService.update(id, updatedRecipe);
	}

	// Brisanje recepta
	@DeleteMapping("/{id}")
	public void deleteRecipe(@PathVariable Long id) {
		recipeService.delete(id);
	}
	
	
}
