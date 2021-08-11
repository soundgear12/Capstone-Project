package com.meritamerica.capstoneproject.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("dbaCheckingAccount")
public class DBACheckingAccount extends BankAccount {

	public String businessName;
	

	public DBACheckingAccount() {
		super();
		this.setInterestRate(.0001);
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

}
