package com.meritamerica.capstoneproject.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("personalCheckingAccount")
public class PersonalCheckingAccount extends BankAccount {

	public PersonalCheckingAccount() {
		super();
		this.setInterestRate(.0001);
	}
}

