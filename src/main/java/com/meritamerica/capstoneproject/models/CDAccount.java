package com.meritamerica.capstoneproject.models;

public class CDAccount extends BankAccount {
	
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
