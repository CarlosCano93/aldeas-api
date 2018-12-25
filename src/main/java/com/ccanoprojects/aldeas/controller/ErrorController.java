package com.ccanoprojects.aldeas.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
	
	private static final String INTERNAL_SERVER_ERROR_VIEW = "error/404";

	@ExceptionHandler(Exception.class)
	public String showInternalServerError() {
		return INTERNAL_SERVER_ERROR_VIEW;
	}
}
