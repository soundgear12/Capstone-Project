package com.meritamerica.capstoneproject.models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("savingsAccount")
public class SavingsAccount extends BankAccount {

	public SavingsAccount(double balance) {
		super();
		this.setBalance(balance);
		this.setInterestRate(.01);
	}
	
	public SavingsAccount() {
		super();
		this.setInterestRate(.01);
	}
	
}
