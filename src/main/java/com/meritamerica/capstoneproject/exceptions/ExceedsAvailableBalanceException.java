package com.meritamerica.capstoneproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceedsAvailableBalanceException extends Exception {

	public ExceedsAvailableBalanceException() {
		System.out.println("ExceedsAvailableBalanceException");
	}

	private static final long serialVersionUID = 1L;
	
}
