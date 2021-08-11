package com.meritamerica.capstoneproject.models;


public class DepositTransaction extends Transaction {

	@Override
	public void process() {
		
	}
	
	public DepositTransaction() {
		
	}
	
	public DepositTransaction(int target, double amount, java.util.Date date, String transactionType) {
		super(target, amount, date, transactionType);
	}

}
