package com.cookbook.service;

import java.util.List;
import java.util.Optional;

import com.cookbook.dto.IngridientDTO;
import com.cookbook.entities.Ingridient;
import com.cookbook.entities.IngridientAllergen;
import com.cookbook.entities.IngridientRecipe;
import com.cookbook.util.RESTError;

public interface IngridientService {
	
	public IngridientDTO addIngridien(IngridientDTO ingriendient);
	
	public IngridientDTO modifyIngridien(Long id, IngridientDTO ingridient)throws RESTError;
	
	public Ingridient deleteIngridien (Long id)throws RESTError;
	
	public Optional<Ingridient> findIngridientById(Long id)throws RESTError;
	
	public List<Ingridient>getAllIngridient();
	
	public List<Ingridient> getByName(String name)throws RESTError;
	
	public List<Ingridient> ingridientFromRecipe (Long id) throws RESTError;
	
	public IngridientAllergen addIngridientAllergen (Long id_ingridient, Long id_allergen)throws RESTError;
	
	public IngridientRecipe addIngridientRecipe (Long id_ingridient, Long id_recipe,Integer quantity)throws RESTError;
	

}
