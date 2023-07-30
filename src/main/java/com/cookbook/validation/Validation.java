package com.cookbook.validation;

import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class Validation {

	
	 public static String createErrorMessage(BindingResult result) {
			return result.getAllErrors().stream().map(ObjectError::getDefaultMessage)
			.collect(Collectors.joining(" "));
			}
	}

