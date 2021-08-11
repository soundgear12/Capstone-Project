package com.meritamerica.capstoneproject.models;

import javax.persistence.*;

@Entity
public class CDAccount extends BankAccount {
	
	@ManyToOne
	@JoinColumn(name = "cdAccount_id", referencedColumnName = "cdAccount_id")
	private CDOffering cdOffering;
	
	public CDAccount(double balance, CDOffering cdOffering) {
		super(balance);
		this.setCdOffering(cdOffering);
	}

	public CDOffering getCdOffering() {
		return cdOffering;
	}
	public void setCdOffering(CDOffering cdOffering) {
		this.cdOffering = cdOffering;
		this.setInterestRate(cdOffering.getInterestRate());
	}

}
