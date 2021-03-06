package com.meritamerica.capstoneproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NegativeAmountException extends Exception {

	public NegativeAmountException() {
		System.out.println("NegativeAmountException");
	}

	private static final long serialVersionUID = 1L;
	
}
