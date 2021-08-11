package com.meritamerica.capstoneproject.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("personalCheckingAccount")
public class PersonalCheckingAccount extends BankAccount {

	public PersonalCheckingAccount() {
		
	}
}

