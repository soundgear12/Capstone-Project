package com.meritamerica.capstoneproject.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "account_holder", catalog = "meritbank")
public class AccountHolder {

	public AccountHolder() {
		firstName = "";
		middleName = "";
		lastName = "";
		ssn = "";
	}
	

	public AccountHolder(String firstName, String middleName, String lastName, String ssn) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
	}


	@Id
	@Column(name = "account_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank
	private String firstName;
	
	
	private String middleName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	private String ssn;
	
	/*
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private AccountHolderContactDetails accountHolderContactDetails;
	
	/*
	@JoinColumn
	private List<CDAccount> cdAccounts;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private List<DBACheckingAccount> dbaCheckingAccounts;
	
	*/

	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	public List<PersonalCheckingAccount> personalCheckingAccounts = new ArrayList<PersonalCheckingAccount>() ;
	/*
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private RegularIRAAccount regularIRAAccounts;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private RolloverIRAAccount rolloverIRAAccounts;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private RothIRAAccount rothIRAAccounts;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private SavingsAccount savingsAccounts;
	*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/*
	public AccountHolderContactDetails getAccountHolderContactDetails() {
		return accountHolderContactDetails;
	}

	public void setAccountHolderContactDetails(AccountHolderContactDetails accountHolderContactDetails) {
		this.accountHolderContactDetails = accountHolderContactDetails;
	}

	/*
	public List<CDAccount> getCdAccounts() {
		return cdAccounts;
	}

	public void setCdAccounts(List<CDAccount> cdAccounts) {
		this.cdAccounts = cdAccounts;
	}

	public List<DBACheckingAccount> getDbaCheckingAccounts() {
		return dbaCheckingAccounts;
	}

	public void setDbaCheckingAccounts(List<DBACheckingAccount> dbaCheckingAccounts) {
		this.dbaCheckingAccounts = dbaCheckingAccounts;
	}

	*/

	public PersonalCheckingAccount addPersonalCheckingAccount(PersonalCheckingAccount personalCheckingAccount) {
		personalCheckingAccounts.add(personalCheckingAccount);
		return personalCheckingAccount;
	}
	
	public List<PersonalCheckingAccount> getPersonalCheckingAccounts() {
		return personalCheckingAccounts;
	}
	

	public void setPersonalCheckingAccounts(List<PersonalCheckingAccount> personalCheckingAccounts) {
		this.personalCheckingAccounts = personalCheckingAccounts;
	}
	
	/*

	public RegularIRAAccount getRegularIRAAccounts() {
		return regularIRAAccounts;
	}

	public void setRegularIRAAccounts(RegularIRAAccount regularIRAAccounts) {
		this.regularIRAAccounts = regularIRAAccounts;
	}

	public RolloverIRAAccount getRolloverIRAAccounts() {
		return rolloverIRAAccounts;
	}

	public void setRolloverIRAAccounts(RolloverIRAAccount rolloverIRAAccounts) {
		this.rolloverIRAAccounts = rolloverIRAAccounts;
	}

	public RothIRAAccount getRothIRAAccounts() {
		return rothIRAAccounts;
	}

	public void setRothIRAAccounts(RothIRAAccount rothIRAAccounts) {
		this.rothIRAAccounts = rothIRAAccounts;
	}

	public SavingsAccount getSavingsAccounts() {
		return savingsAccounts;
	}

	public void setSavingsAccounts(SavingsAccount savingsAccounts) {
		this.savingsAccounts = savingsAccounts;
	}

	*/
}
