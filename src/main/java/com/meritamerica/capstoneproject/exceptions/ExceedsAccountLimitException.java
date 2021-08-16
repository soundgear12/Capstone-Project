package com.meritamerica.capstoneproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExceedsAccountLimitException extends Exception {
	
	public ExceedsAccountLimitException() {
		super("You have reached the account limit for this account type");
	}

	private static final long serialVersionUID = 1L;
	
}
