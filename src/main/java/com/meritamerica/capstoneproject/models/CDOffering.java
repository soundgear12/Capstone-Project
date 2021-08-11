package com.meritamerica.capstoneproject.models;

import javax.persistence.*;


@Entity
public class CDOffering {
	
	@Id
	@Column(name = "cdAccount_id")
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
