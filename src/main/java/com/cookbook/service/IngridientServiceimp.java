package com.cookbook.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookbook.dto.IngridientDTO;
import com.cookbook.entities.Allergen;
import com.cookbook.entities.Ingridient;
import com.cookbook.entities.IngridientAllergen;
import com.cookbook.entities.IngridientRecipe;
import com.cookbook.entities.Recipe;
import com.cookbook.mappers.IngridientMapper;
import com.cookbook.repositories.AllergenRepository;
import com.cookbook.repositories.IngridientAllergenRepository;
import com.cookbook.repositories.IngridientRecipeRepository;
import com.cookbook.repositories.IngridientRepository;
import com.cookbook.repositories.RecipeRepository;
import com.cookbook.util.RESTError;
@Service
public class IngridientServiceimp implements IngridientService {
	
	@Autowired
	IngridientMapper ingridientMapper;
	@Autowired
	IngridientRepository ingridientRepository;
	@Autowired
	RecipeRepository recipeRepository;
	@Autowired
	AllergenRepository allergenRepository;
	@Autowired
	IngridientAllergenRepository ingridientAllergenRepository;
	@Autowired
	IngridientRecipeRepository ingridientRecipeRepository;

	@Override
	public IngridientDTO addIngridien(IngridientDTO ingridient) {
		
		ingridient.setDeleted(false);
		return ingridientMapper.toDto(ingridientRepository.save(ingridientMapper.toEntity(ingridient)));
	}

	@Override
	public IngridientDTO modifyIngridien(Long id, IngridientDTO ingridient) throws RESTError {
		if (!ingridientRepository.existsById(id)) {
			throw new RESTError(1, "ingridient not exists");
		}
		Ingridient existingAllergen= ingridientRepository.findById(id).get();
		
		existingAllergen.setName(ingridient.getName());
		existingAllergen.setServingSize(ingridient.getServingSize());
		existingAllergen.setCalories(ingridient.getCalories());
		existingAllergen.setCarbs(ingridient.getCarbs());
		existingAllergen.setSugars(ingridient.getSugars());
		existingAllergen.setFats(ingridient.getFats());
		existingAllergen.setSaturatedFats(ingridient.getSaturatedFats());
		existingAllergen.setProteins(ingridient.getProteins());
		
		Ingridient savedIngridien= ingridientRepository.save(existingAllergen);
		
		return ingridientMapper.toDto(savedIngridien);
	}

	@Override
	public Ingridient deleteIngridien(Long id) throws RESTError {
		Optional<Ingridient> ingridient = ingridientRepository.findById(id);
		if (ingridient.isEmpty()) {
			throw new RESTError(1, "Ingridient not exists");
		}
		Ingridient ingridientEntity = ingridient.get();
		ingridientEntity.setDeleted(true);
		return ingridientRepository.save(ingridientEntity);
		
	}

	@Override
	public Optional<Ingridient> findIngridientById(Long id) throws RESTError {
		
		 Optional<Ingridient> ingridient = ingridientRepository.findById(id);
		    if (!ingridient.isEmpty()&& ingridient.get().getDeleted()==false) {
		        return ingridient;
		    } else {
		        throw new RESTError(1, "Ingridient not exists");
		    }
	}

	@Override
	public List<Ingridient> getAllIngridient() {
		
		return ingridientRepository.findByDeletedFalse();
	}

	@Override
	public List<Ingridient> getByName(String name) throws RESTError {
		List<Ingridient>ingridient=ingridientRepository.findByDeletedFalseAndNameIgnoreCaseContaining(name);
		if(ingridient.isEmpty()) {
			throw new RESTError(1, "Ingridient not exists");
		}
		return ingridient;
	}

//	Pretraga svih sastojaka integrisana u pisanje recepta.
	
	public List<Ingridient> ingridientFromRecipe (Long id) throws RESTError{

	if(!recipeRepository.existsById(id)) {
		throw new RESTError(1, "Recipe not exists");
	}
	Recipe recipe=recipeRepository.findById(id).get();
	
		List<Ingridient> ingridients = recipe.getIngridientRecipe().stream()
				.map(IngridientRecipe::getIngridient)
				.collect(Collectors.toList());
		

		return ingridients;
		
	}
// add za srednju tabelu IngridientAllergen
	@Override
	public IngridientAllergen addIngridientAllergen(Long id_ingridient, Long id_allergen) throws RESTError {
		if(!ingridientRepository.existsById(id_ingridient)) {
			throw new RESTError(1, "Ingridient not exists");
		}
		Ingridient ingridient=ingridientRepository.findById(id_ingridient).get();
		
		if(!allergenRepository.existsById(id_allergen)) {
			throw new RESTError(1, "Allergen not exists");
		}
		Allergen allergen= allergenRepository.findById(id_allergen).get();
		
		IngridientAllergen ingridientAllergen= new IngridientAllergen(allergen,ingridient,false);
		return ingridientAllergenRepository.save(ingridientAllergen);
	}
// add za srednju tabelu IngridientRecipe
	@Override
	public IngridientRecipe addIngridientRecipe(Long id_ingridient, Long id_recipe,Integer quantity) throws RESTError {
	
		if(!ingridientRepository.existsById(id_ingridient)) {
			throw new RESTError(1, "Ingridient not exists");
		}
		Ingridient ingridient=ingridientRepository.findById(id_ingridient).get();
		
		if(!recipeRepository.existsById(id_recipe)) {
			throw new RESTError(1, "Recipe not exists");
		}
		Recipe recipe=recipeRepository.findById(id_recipe).get();
		
		IngridientRecipe ingridientRecipe= new IngridientRecipe(quantity,recipe,ingridient,false);
		return ingridientRecipeRepository.save(ingridientRecipe);
	}
	
	
}
