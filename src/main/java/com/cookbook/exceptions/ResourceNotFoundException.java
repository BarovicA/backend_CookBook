package com.cookbook.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("Resource '%s' not found with '%s' : '%s'", resourceName, fieldName, fieldValue));
    }

}
