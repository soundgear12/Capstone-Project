package com.meritamerica.capstoneproject.models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("rolloverIRAAccount")
public class RolloverIRAAccount extends BankAccount {

	public RolloverIRAAccount() {
		super();
		this.setInterestRate(.01);
	}
	
}
