
package com.atk.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyProjectExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Map<String, String>> handlerResourceNotFound(NotFoundException ex) {

		Map<String, String> error = new HashMap<>();
		error.put("error", ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}

}
