package com.meritamerica.capstoneproject.models;

import javax.persistence.*;

import org.springframework.web.bind.annotation.*;

@Entity
@Table(name = "User", catalog = "meritBank")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String userName;
	
	@Column
	private String password;
	
	@Column
	private String roles;
	
	@Column
	private boolean active ;
	
	public User() {
		userName = "";
		password = "";
		roles = "";
		active = true;
	
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id", referencedColumnName = "account_id")
	AccountHolder accountHolder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	
	
	
	
	
	
	
}
