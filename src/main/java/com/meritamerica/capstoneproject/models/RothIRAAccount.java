package com.meritamerica.capstoneproject.models;

import javax.persistence.*;

@Entity
@DiscriminatorValue("rothIRAAccount")
public class RothIRAAccount extends BankAccount {

	public RothIRAAccount() {
		super();
		this.setInterestRate(.01);
	}
	
}
