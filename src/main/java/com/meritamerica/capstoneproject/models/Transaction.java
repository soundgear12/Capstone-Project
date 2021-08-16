package com.meritamerica.capstoneproject.models;

import java.util.Date;

import javax.persistence.*;

@Entity
public abstract class Transaction {

	@Id
	@Column(name = "transaction_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int target;
	
	private int source;
	
	private double amount;
	
	private java.util.Date date;
	
	private String transactionType;
	
	Transaction () {
		
	}
	
	public Transaction(int target, int source, double amount, java.util.Date date, String transactionType) {

		this.target = target;
		this.source = source;
		this.amount = amount;
		this.date = new Date();
		this.transactionType = transactionType;
	}
	
	public Transaction(int target, double amount, java.util.Date date, String transactionType) {

		this.target = target;
		this.amount = amount;
		this.date = new Date();
		this.transactionType = transactionType;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate() {
		this.date = new Date();
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	public abstract void process();
	
}
