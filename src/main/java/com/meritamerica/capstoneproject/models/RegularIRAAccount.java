package com.meritamerica.capstoneproject.models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("regularIRAAccount")
public class RegularIRAAccount extends BankAccount {

	public RegularIRAAccount() {
		super();
		this.setInterestRate(.01);
	}
	
}
