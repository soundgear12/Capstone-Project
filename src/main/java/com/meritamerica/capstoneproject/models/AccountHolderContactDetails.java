package com.meritamerica.capstoneproject.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "contact_details", catalog = "meritBank")
public class AccountHolderContactDetails {

	@Id
	@Column(name = "contact_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String phoneNumber;
	private String address;
	private String zipcode;
	private String city;
	private String state;
	private String email;
	
	AccountHolderContactDetails() {
		
	}
	
	public AccountHolderContactDetails(String phoneNumber, String address, String zipcode, String city, String state,
			String email) {
		super();
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.state = state;
		this.email = email;
	}

	@OneToOne
	@JoinColumn(name = "contact_id", referencedColumnName = "account_id")
	@JsonBackReference
	private AccountHolder accountHolder;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	
}
