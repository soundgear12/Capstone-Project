package com.meritamerica.capstoneproject.models;

import java.util.Date;

import javax.persistence.DiscriminatorType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import org.hibernate.annotations.DiscriminatorOptions;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.meritamerica.capstoneproject.exceptions.ExceedsAvailableBalanceException;
import com.meritamerica.capstoneproject.exceptions.NegativeAmountException;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="account_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorOptions(force=true)
public abstract class BankAccount {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long accountNumber;
	
	@Min(value = 0)
	private double balance;
	
	private double interestRate;
	
	private Date accountOpenDate;
	
	
	@ManyToOne
	@JoinColumn(name = "account_holder_id")
	@JsonBackReference
	private AccountHolder accountHolder;

	public BankAccount() {
		this.accountOpenDate = new Date();
	}

	public BankAccount(double balance) {
		this.balance = balance;
		this.accountOpenDate = new Date();
	}

	public BankAccount(double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenDate = new Date();
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}

	public long getAccountNumber() {
		return accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public Date getAccountOpenDate() {
		return accountOpenDate;
	}
	public void setAccountOpenDate(Date accountOpenDate) {
		this.accountOpenDate = accountOpenDate;
	}

	public void deposit(double amt) throws NegativeAmountException {
		if ( amt < 0 ) {
			throw new NegativeAmountException();
		}
		balance += amt;
	}
	public void withdraw(double amt) throws NegativeAmountException, ExceedsAvailableBalanceException {
		if ( amt < 0 ) {
			throw new NegativeAmountException();
		}
		if ( amt > balance ) {
			throw new ExceedsAvailableBalanceException();
		}
		balance -= amt;
	}

}
