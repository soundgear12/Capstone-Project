package com.meritamerica.capstoneproject.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
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

	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private AccountHolderContactDetails accountHolderContactDetails;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<CDAccount> cdAccounts = new ArrayList<CDAccount>();

	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<DBACheckingAccount> dbaCheckingAccounts = new ArrayList<DBACheckingAccount>();

	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	public List<PersonalCheckingAccount> personalCheckingAccounts = new ArrayList<PersonalCheckingAccount>();

	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<RegularIRAAccount> regularIRAAccounts = new ArrayList<RegularIRAAccount>();

	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<RolloverIRAAccount> rolloverIRAAccounts = new ArrayList<RolloverIRAAccount>();;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<RothIRAAccount> rothIRAAccounts = new ArrayList<RothIRAAccount>();;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	public List<SavingsAccount> savingsAccounts = new ArrayList<SavingsAccount>();

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

	public AccountHolderContactDetails getAccountHolderContactDetails() {
		return accountHolderContactDetails;
	}

	public void setAccountHolderContactDetails(AccountHolderContactDetails accountHolderContactDetails) {
		this.accountHolderContactDetails = accountHolderContactDetails;
	}

	public CDAccount addCDAccount(CDAccount cdAccount) {
		cdAccounts.add(cdAccount);
		return cdAccount;
	}

	public List<CDAccount> getCdAccounts() {
		return cdAccounts;
	}

	public void setCdAccounts(List<CDAccount> cdAccounts) {
		this.cdAccounts = cdAccounts;
	}

	public DBACheckingAccount addDBACheckingAccount(DBACheckingAccount dbaCheckingAccount) {

		dbaCheckingAccounts.add(dbaCheckingAccount);
		return dbaCheckingAccount;

	}

	public List<DBACheckingAccount> getDbaCheckingAccounts() {
		return dbaCheckingAccounts;
	}

	public void setDbaCheckingAccounts(List<DBACheckingAccount> dbaCheckingAccounts) {
		this.dbaCheckingAccounts = dbaCheckingAccounts;
	}

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

	public RegularIRAAccount addRegularIRAAccount(RegularIRAAccount regularIRAAccount) {
		regularIRAAccounts.add(regularIRAAccount);
		return regularIRAAccount;

	}

	public List<RegularIRAAccount> getRegularIRAAccounts() {
		return regularIRAAccounts;
	}

	public void setRegularIRAAccounts(List<RegularIRAAccount> regularIRAAccounts) {
		this.regularIRAAccounts = regularIRAAccounts;
	}

	public RolloverIRAAccount addRolloverIRAAccount(RolloverIRAAccount rolloverIRAAccount) {
		rolloverIRAAccounts.add(rolloverIRAAccount);
		return rolloverIRAAccount;

	}

	
	public List<RolloverIRAAccount> getRolloverIRAAccounts() {
		return rolloverIRAAccounts;
	}

	public void setRolloverIRAAccounts(List<RolloverIRAAccount> rolloverIRAAccounts) {
		this.rolloverIRAAccounts = rolloverIRAAccounts;
	}

	public List<RothIRAAccount> getRothIRAAccounts() {
		return rothIRAAccounts;
	}

	public RothIRAAccount addRothIRAAccount(RothIRAAccount rothIRAAccount) {
		rothIRAAccounts.add(rothIRAAccount);
		return rothIRAAccount;
	}

	public void setRothIRAAccounts(List<RothIRAAccount> rothIRAAccounts) {
		this.rothIRAAccounts = rothIRAAccounts;
	}

	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {

		savingsAccounts.add(savingsAccount);
		return savingsAccount;

	}

	public List<SavingsAccount> getSavingsAccounts() {
		return savingsAccounts;
	}

	public void setSavingsAccounts(List<SavingsAccount> savingsAccounts) {
		this.savingsAccounts = savingsAccounts;
	}

}
