package com.meritamerica.capstoneproject.models;

public class WithdrawTransaction extends Transaction {

	@Override
	public void process() {
		
	}

	public WithdrawTransaction() {
		
	}
	
	public WithdrawTransaction(int target, double amount, java.util.Date date, String transactionType) {
		super(target, amount, date, transactionType);
	}
	
}
