package com.meritamerica.capstoneproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExceedsCombinedBalanceException extends Exception {

	public ExceedsCombinedBalanceException() {
		System.out.println("ExceedsCombinedBalanceLimitException");
	}

	private static final long serialVersionUID = 1L;
	
}
