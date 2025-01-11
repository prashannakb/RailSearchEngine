package com.rail.search.engine.exception;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.annotations.Collate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rail.search.engine.entity.dto.ErrorMessage;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(SearchException.class)
	private ResponseEntity<ErrorMessage> searchexceptionHandler(SearchException ex){
		ErrorMessage error=new ErrorMessage();
		error.setMsg(ex.getMessage());
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(error,new HttpHeaders(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	private ResponseEntity<ErrorMessage> mathodargumentNotValidexceptionHandler(MethodArgumentNotValidException ex){
		ErrorMessage error=new ErrorMessage();
		error.setMsg(ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(",")));
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(error,new HttpHeaders(),HttpStatus.BAD_REQUEST);
		
	}

	
	@ExceptionHandler(ConstraintViolationException .class)
	private ResponseEntity<ErrorMessage> sConfigurationVoilationexceptionHandler(ConstraintViolationException ex){
		ErrorMessage error=new ErrorMessage();
		error.setMsg(ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(",")));
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(error,new HttpHeaders(),HttpStatus.BAD_REQUEST);
		
	}

}
