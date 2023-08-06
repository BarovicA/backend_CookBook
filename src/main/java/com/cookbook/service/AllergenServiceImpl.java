package com.cookbook.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookbook.dto.AllergenDTO;
import com.cookbook.entities.Allergen;
import com.cookbook.entities.AllergenRegularUser;
import com.cookbook.entities.Ingridient;
import com.cookbook.entities.IngridientAllergen;
import com.cookbook.entities.IngridientRecipe;
import com.cookbook.entities.Recipe;
import com.cookbook.entities.RegularUser;
import com.cookbook.mappers.AllergenMapper;
import com.cookbook.repositories.AllergenRegularUserRepository;
import com.cookbook.repositories.AllergenRepository;
import com.cookbook.repositories.RecipeRepository;
import com.cookbook.repositories.RegularUserRepository;
import com.cookbook.util.RESTError;


@Service
public class AllergenServiceImpl implements AllergenService {
	
	@Autowired
	AllergenMapper allergenMapper;
	@Autowired
	AllergenRepository allergenRepository;
	@Autowired
	RecipeRepository recipeRepository;
	@Autowired
	RegularUserRepository regularUserRepository; 
	@Autowired
	AllergenRegularUserRepository allergenRegularUserRepository;
	

	@Override
	public AllergenDTO addAllergen(AllergenDTO allergen) {
		
		allergen.setDeleted(false);
		return allergenMapper.toDto(allergenRepository.save(allergenMapper.toEntity(allergen)));
		
	}

	@Override

	public AllergenDTO modifyAllergen(Long id, AllergenDTO allergenDTO) throws RESTError {
	    if (!allergenRepository.existsById(id)) {
	        throw new RESTError(1, "Allergen with the given id does not exist.");
	    }
	   	  
	    Allergen existingAllergen = allergenRepository.findById(id).get();
	    
	    existingAllergen.setName(allergenDTO.getName());
	    existingAllergen.setIcon(allergenDTO.getIcon());
	    existingAllergen.setDeleted(allergenDTO.getDeleted());
	   
	    Allergen savedAllergen = allergenRepository.save(existingAllergen);
	 
	    return allergenMapper.toDto(savedAllergen);
	}


	@Override
	public Allergen deleteAllergen(Long id) throws RESTError {
		
		Optional<Allergen> allergen = allergenRepository.findById(id);
		if (allergen.isEmpty()) {
			throw new RESTError(1, "allergen not exists");
		}
		Allergen allergenEntity = allergen.get();
		allergenEntity.setDeleted(true);
		return allergenRepository.save(allergenEntity);
	}

	@Override
	public Optional<Allergen> findIngridientById(Long id) throws RESTError {
		Optional<Allergen> allergen = allergenRepository.findById(id);
	    if (!allergen.isEmpty()&& allergen.get().getDeleted()==false) {
	        return allergen;
	    } else {
	        throw new RESTError(1, "Allergen not exists");
	    }
}

	@Override
	public List<Allergen> getAllAllergen() {
		
		return allergenRepository.findByDeletedFalse();
	}

	@Override
	public List<Allergen> getByName(String name) throws RESTError {
		List<Allergen>allergen=allergenRepository.findByDeletedFalseAndNameIgnoreCaseContaining(name);
		if(allergen.isEmpty()) {
			throw new RESTError(1, "Allergen not exists");
		}
		return allergen;
	}
//	Prikaz dinamički sračunatih podataka o alergenima/OF kod prikaza i pretraga receptima.
	@Override
	public Set<Allergen> allergenFromRecipe (Long id) throws RESTError{
//		Optional <Recipe>recipeOptional = recipeRepository.findById(id);
	if(recipeRepository.findById(id).isEmpty()) {
		throw new RESTError(1, "Recipe not exists");
	}
	Recipe recipe=recipeRepository.findById(id).get();
		List<Ingridient> ingridients = recipe.getIngridientRecipe().stream()
				.map(IngridientRecipe::getIngridient)
				.collect(Collectors.toList());
		
		Set<Allergen> allergens = ingridients.stream()
			    .flatMap(ingridient -> ingridient.getIngridientAllergen().stream()
			    .map(IngridientAllergen::getAllergen))
			    .collect(Collectors.toSet());

		return allergens;
		
	}
//	Dodavanje ličnih alergena/ograničavajućih faktora (OF)
	@Override
		public AllergenRegularUser addPersonAllergen(Long regularUserId, Long allergenId)throws RESTError{
			if(!regularUserRepository.existsById(regularUserId)) {
				throw new RESTError(1, "Regular user not exists");
			}
			RegularUser regular=regularUserRepository.findById(regularUserId).get();
			
			if(!allergenRepository.existsById(allergenId)) {
				throw new RESTError(1, "Allergen not exists");
			}
			Allergen allergen= allergenRepository.findById(allergenId).get();
		
			if(allergenRegularUserRepository.existsByAllergenAndRegUser(allergen, regular)) {
				throw new RESTError(1, "Already exist allergen for this user");
			}
			AllergenRegularUser allergenRegularUser= new AllergenRegularUser(allergen,regular,false);
			return allergenRegularUserRepository.save(allergenRegularUser);
			
		}
	
//	Brisanje ličnih alergena/OF

	@Override
	public AllergenRegularUser deletePersonAllergen(Long id)throws RESTError{
	
		if(!allergenRegularUserRepository.existsById(id)){
			throw new RESTError(1, "not exist");
		}
		AllergenRegularUser allergenRegularUser= allergenRegularUserRepository.findById(id).get();
		allergenRegularUser.getAllergen().setDeleted(true);
		return allergenRegularUserRepository.save(allergenRegularUser);
		
	}
	
//	Prikaz liste ličnih alergena/OF
	@Override
	public Set<Allergen> viewPersonalallergen (Long id) throws RESTError{
		
	if(regularUserRepository.findById(id).isEmpty()) {
		throw new RESTError(1, "User not exists");
	}
	RegularUser user=regularUserRepository.findById(id).get();
		Set<Allergen> allergens = user.getAllergenRegularUser().stream()
				.map(AllergenRegularUser::getAllergen)
				.collect(Collectors.toSet());
		return allergens;
	}
	
//	Moji alergeni
	@Override
	public AllergenRegularUser addAllergenRegularUser(Long allergen_id,Long regularUser_id)throws RESTError{
		if(regularUserRepository.findById(regularUser_id).isEmpty()) {
			throw new RESTError(1, "User not exists");
		}
		RegularUser user=regularUserRepository.findById(regularUser_id).get();
		
		if(allergenRepository.findById(allergen_id).isEmpty()) {
			throw new RESTError(1, "allergen not exists");
		}
		Allergen allergen=allergenRepository.findById(allergen_id).get();
		
		AllergenRegularUser allergenRegularUser= new AllergenRegularUser(allergen,user,false);
		return allergenRegularUserRepository.save(allergenRegularUser);
	}
}