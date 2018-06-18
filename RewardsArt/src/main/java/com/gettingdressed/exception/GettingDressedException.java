package com.gettingdressed.exception;

import com.gettingdressed.enums.ERRORS;

public class GettingDressedException extends Exception {

	private static final long serialVersionUID = 1L;
	private Exception exception;
	private String message; 
	private Integer valueCausedException;
	private ERRORS errorsEnum;

	
	public ERRORS getErrorsEnum() {
		return errorsEnum;
	}

	public GettingDressedException(ERRORS errorsEnum) {
		this.errorsEnum = errorsEnum;
	}

	public GettingDressedException(String message) {
		this.message = message;
	}
	
	public GettingDressedException(Exception e) {
		this.exception = e;
	}
	
	public GettingDressedException(Integer value) {
		this.valueCausedException = value;
	}
	
	public Integer getValueCausedException() {
		return valueCausedException;
	}

	public void setValueCausedException(Integer valueCausedException) {
		this.valueCausedException = valueCausedException;
	}

	public String getExceptionMessage() {
		return this.exception.getMessage();
	}

  	public String getMessage(){
		return this.message; 
	}

}
