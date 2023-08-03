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
import com.cookbook.repositories.AdminUserRepository;
import com.cookbook.service.AdminUserService;
import com.cookbook.util.RESTError;

import jakarta.validation.Valid;


@RestController
@RequestMapping(path = "/api/v1/adminuser")
public class AdminUserController {

	@Autowired
	AdminUserService adminUserService;
	@Autowired
	AdminUserRepository adminUserRepository;
	
	private String createErrorMessage(BindingResult result) {
		return result.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(" "));
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addAdminUser(@Valid @RequestBody AdminUserDTO adminUser, BindingResult result) throws RESTError  {
        System.out.println("usli");
        AdminUserDTO  admin = adminUserService.addAdminUser(adminUser);
        if (result.hasErrors()) {
            return new ResponseEntity<>(createErrorMessage(result), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }
	
	 @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	    public ResponseEntity<?> modifyAdminUser(@PathVariable Long id, @Valid @RequestBody AdminUserDTO adminUser, BindingResult result) {
	        try {
	            if (result.hasErrors()) {
	                return new ResponseEntity<>(createErrorMessage(result), HttpStatus.BAD_REQUEST);
	            }
	            adminUserService.modifyAdminUser(id, adminUser);
	            return new ResponseEntity<>(adminUser, HttpStatus.OK);
	        } catch (RESTError e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	        }
	    }
	 
	 @RequestMapping(method = RequestMethod.GET, value = "/{id}")
	    public ResponseEntity<?> getAdminUser(@PathVariable Long id) {
	        AdminUserDTO adminUser = adminUserService.getAdminUserById(id);
	        if (adminUser == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Admin user not found");
	        }
	        return ResponseEntity.ok(adminUser);
	        
	    }
	 @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	    public ResponseEntity<?> deleteAdminUser(@PathVariable Long id) {
	        try {
	            adminUserService.deleteAdminUser(id);
	            return ResponseEntity.ok("Admin user deleted successfully");
	        } catch (RESTError e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	        }
	    }
}
