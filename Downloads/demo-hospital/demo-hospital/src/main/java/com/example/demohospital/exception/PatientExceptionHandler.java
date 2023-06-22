package com.example.demohospital.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class PatientExceptionHandler {
	@ExceptionHandler(value= {PatientNotFoundException.class})
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ErrorResponce handlePatientNotFoundException(PatientNotFoundException ptnt) {
		return new ErrorResponce(HttpStatus.NOT_FOUND.toString(),ptnt.getMessage(),LocalDateTime.now());
	}
		
		@ExceptionHandler(value= PatientAlreadyExistException.class)
		@ResponseStatus(value=HttpStatus.CONFLICT)
		public ErrorResponce handlePatientAlreadyExistException(PatientAlreadyExistException ptnt) {
			return new ErrorResponce(HttpStatus.CONFLICT.toString(),ptnt.getMessage(),LocalDateTime.now());
		}
		
		@ExceptionHandler(value= Exception.class)
		@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
		public ErrorResponce handleException(Exception ptnt) {
			ptnt.printStackTrace();
			return new ErrorResponce(HttpStatus.INTERNAL_SERVER_ERROR.toString(),"Unknown error occured",LocalDateTime.now());
	}

}
