package com.cookbook.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookbook.dto.RecipeDTO;
import com.cookbook.entities.Ingridient;
import com.cookbook.entities.IngridientAllergen;
import com.cookbook.entities.IngridientRecipe;
import com.cookbook.entities.Recipe;
import com.cookbook.exceptions.ResourceNotFoundException;
import com.cookbook.repositories.IngridientRecipeRepository;
import com.cookbook.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	RecipeRepository recipeRepository;

	@Autowired
	IngridientRecipeRepository ingridientRecipeRepository;

	@Override
	public Recipe createNew(Recipe newRecipe) {
		Recipe recipe = new Recipe();
		recipe.setName(newRecipe.getName());
		recipe.setDecription(newRecipe.getDecription());
		recipe.setSteps(newRecipe.getSteps());
		recipe.setTimeToPrepare(newRecipe.getTimeToPrepare());
		recipe.setExpectedYieldInGrams(newRecipe.getExpectedYieldInGrams());
		recipe.setDeleted(false);
		return recipeRepository.save(recipe);
	}

	@Override
	public List<Recipe> getAll() {
		return recipeRepository.findByDeletedFalse();
	}

	@Override
	public Recipe getById(Long id) {
		return recipeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recipe", "id", id));
	}

	@Override
	public List<Recipe> getByName(String name) {
		List<Recipe> recipes = recipeRepository.findByDeletedFalseAndNameIgnoreCaseContaining(name);
		if (recipes.isEmpty()) {
			throw new ResourceNotFoundException("Recipe", "name", name);
		}
		return recipes;
	}

	@Override
	public Recipe update(Long id, Recipe updatedRecipe) {
		return recipeRepository.findById(id).map(recipe -> {
			recipe.setName(updatedRecipe.getName());
			recipe.setDecription(updatedRecipe.getDecription());
			recipe.setSteps(updatedRecipe.getSteps());
			recipe.setTimeToPrepare(updatedRecipe.getTimeToPrepare());
			recipe.setExpectedYieldInGrams(updatedRecipe.getExpectedYieldInGrams());
			return recipeRepository.save(recipe);
		}).orElseThrow(() -> new ResourceNotFoundException("Recipe", "id", id));
	}

	@Override
	public void delete(Long id) {
		Recipe recipe = getById(id);
		recipe.setDeleted(true);
		recipeRepository.save(recipe);
	}

	@Override
	public RecipeDTO getByIdDto(long id) {
		Recipe recipe = recipeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recipe", "id", id));

		RecipeDTO recipeDTO = new RecipeDTO();
		recipeDTO.setName(recipe.getName());
		recipeDTO.setDecription(recipe.getDecription());
		recipeDTO.setSteps(recipe.getSteps());
		recipeDTO.setTimeToPrepare(recipe.getTimeToPrepare());
		recipeDTO.setExpectedYieldInGrams(recipe.getExpectedYieldInGrams());

		List<IngridientRecipe> sastojciRecepta = recipe.getIngridientRecipe();

		int ukupnaEnergija = 0;
		Set<String> setAlergena = new HashSet<>(); // Set da bi izbegli duplikate

		for (IngridientRecipe sastojakRecepta : sastojciRecepta) {
			Ingridient sastojak = sastojakRecepta.getIngridient();
			// Računanje energije
			ukupnaEnergija += sastojak.getCalories() * sastojakRecepta.getQuantity();

			// Izvlačenje alergena za sastojak
			List<IngridientAllergen> alergeniSastojka = sastojak.getIngridientAllergen();
			for (IngridientAllergen alergenSastojka : alergeniSastojka) {
				setAlergena.add(alergenSastojka.getAllergen().getName());
			}

			// Konverzija energije za 100g
			int energijaNa100g = recipe.getExpectedYieldInGrams() != 0
					? (ukupnaEnergija / recipe.getExpectedYieldInGrams()) * 100
					: 0;
			recipeDTO.setEnergy(energijaNa100g);

			// Konverzija seta alergena u listu
			recipeDTO.setAllergens(new ArrayList<>(setAlergena));

		}
		return recipeDTO;
	}
}
