package com.meritamerica.capstoneproject.models;

public class TransferTransaction extends Transaction {

	@Override
	public void process() {
		
	}

	public TransferTransaction() {
		
	}
	
	public TransferTransaction(int target, double amount, java.util.Date date, String transactionType) {
		super(target, amount, date, transactionType);
	}
}
