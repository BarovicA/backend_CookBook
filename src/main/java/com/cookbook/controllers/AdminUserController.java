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

import com.cookbook.entities.AdminUser;
import com.cookbook.repositories.AdminUserRepository;
import com.cookbook.service.AdminUserService;
import com.cookbook.util.RESTError;
import com.cookbook.validation.Validation;

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

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public ResponseEntity<?> addAdminUser(@Valid @RequestBody AdminUser adminUser, BindingResult result)
			throws RESTError {
//		System.out.println(
//				adminUser.getFirstName() + adminUser.getLastName() + adminUser.getPassword() + adminUser.getUsername());
		if (result.hasErrors()) {
			return new ResponseEntity<>(Validation.createErrorMessage(result), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(adminUserService.addAdminUser(adminUser), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<?> modifyAdminUser(@PathVariable Long id, @Valid @RequestBody AdminUser adminUser, BindingResult result)
			throws RESTError {
		if (result.hasErrors()) {
			return new ResponseEntity<>(Validation.createErrorMessage(result), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(adminUserService.modifyAdminUser(id, adminUser), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> getAdminUser(@PathVariable Long id) {
		return ResponseEntity.ok(adminUserService.getAdminUserById(id));
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteAdminUser(@PathVariable Long id) {
		try {

			AdminUser deletedAdminUser = adminUserService.deleteAdminUser(id);

			if (deletedAdminUser == null) {
				return ResponseEntity.ok("Admin user not found");
			} else {
				return ResponseEntity.ok("Admin user not exsist");
			}

		} catch (RESTError e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
