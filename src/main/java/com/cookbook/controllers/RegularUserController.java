package com.cookbook.controllers;

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

import com.cookbook.dto.AdminUserDTO;
import com.cookbook.dto.RegularUserDTO;
import com.cookbook.entities.AdminUser;
import com.cookbook.entities.RegularUser;
import com.cookbook.repositories.RegularUserRepository;
import com.cookbook.service.RegularUserService;
import com.cookbook.util.RESTError;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/regularuser")
public class RegularUserController {

	 @Autowired
	 RegularUserService regularUserService;
	 
	 @Autowired
	 RegularUserRepository regularUserRepository;
	 
	 private String createErrorMessage(BindingResult result) {
	        return result.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(" "));
	    }

	    @RequestMapping(method = RequestMethod.POST,value = "/add")
	    public ResponseEntity<?> addRegularUser(@RequestBody RegularUserDTO regularUser, BindingResult result) throws RESTError {
	    	 System.out.println(regularUser.getFirstName() + regularUser.getLastName()+ regularUser.getPassword()+regularUser.getUsername());
	    	 RegularUserDTO  RegularUser = regularUserService.addRegularUser(regularUser);
	    	 if (result.hasErrors()) {
	             return new ResponseEntity<>(createErrorMessage(result), HttpStatus.BAD_REQUEST);
	         }
	         return new ResponseEntity<>(regularUser, HttpStatus.OK);
	     }

	    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	    public ResponseEntity<?> modifyRegularUser(@PathVariable Long id,  @RequestBody RegularUserDTO regularUser, BindingResult result) {
	        try {
	            if (result.hasErrors()) {
	                return new ResponseEntity<>(createErrorMessage(result), HttpStatus.BAD_REQUEST);
	            }
	            regularUserService.modifyRegularUser(id, regularUser);
	            return new ResponseEntity<>(regularUser, HttpStatus.OK);
	        } catch (RESTError e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	        }
	    }

//	    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
//	    public ResponseEntity<?> removeRegularUser(@PathVariable Long id) {
//	        try {
//	            return ResponseEntity.status(HttpStatus.OK).body(regularUserService.deleteRegularUser(id));
//	        } catch (RESTError e) {
//	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//	        }
//	    }

	    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	    public ResponseEntity<?> deleteRegularUser(@PathVariable Long id) {
	        try 
	        {
	            
	        	RegularUser deletedRegularUser= regularUserService.deleteRegularUser(id);
	           
	        	if (deletedRegularUser==null) {
	        		return ResponseEntity.ok("Admin user not found");
		        } else {
		        	return ResponseEntity.ok("Admin user not exsist");
		        } 
	            		
	        } catch (RESTError e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	        }
	    }
	
}
