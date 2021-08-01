package com.meritamerica.capstoneproject.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CDOffering {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private double interestRate;
	
	public long getId() {
		return id;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

}
