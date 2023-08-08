//package com.cookbook.controllers;
//
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.ObjectError;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cookbook.dto.UserDTO;
//import com.cookbook.repositories.AllergenRepository;
//import com.cookbook.repositories.UserRepository;
//import com.cookbook.service.AllergenService;
//import com.cookbook.service.UserService;
//import com.cookbook.util.RESTError;
//
//import jakarta.validation.Valid;
//
//@RestController
//@RequestMapping(path = "/api/v1/user")
//public class UserController {
//	
//	@Autowired
//	UserService userService;
//	@Autowired
//	UserRepository userRepository;
//	
//	private String createErrorMessage(BindingResult result) {
//		return result.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(" "));
//	}
//	
//	@RequestMapping(method = RequestMethod.POST)
//	public ResponseEntity<?> addUser(@Valid @RequestBody UserDTO userDTO, BindingResult result) throws RESTError {
//	    System.out.println(userDTO.getFirstName() + userDTO.getLastName() + userDTO.getPassword() + userDTO.getUsername());
//	    UserDTO user = userService.addUser(userDTO);
//	    if (result.hasErrors()) {
//	        return new ResponseEntity<>(createErrorMessage(result), HttpStatus.BAD_REQUEST);
//	    }
//	    return new ResponseEntity<>(user, HttpStatus.OK);
//	}
//
//}
