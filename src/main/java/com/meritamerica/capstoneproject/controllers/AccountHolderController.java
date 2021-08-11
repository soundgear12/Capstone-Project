package com.meritamerica.capstoneproject.controllers;

import java.util.List;

import javax.validation.Valid;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import com.meritamerica.capstoneproject.models.AccountHolder;
import com.meritamerica.capstoneproject.models.PersonalCheckingAccount;
import com.meritamerica.capstoneproject.repository.AccountHolderRepository;
import com.meritamerica.capstoneproject.repository.PersonalCheckingAccountRepository;
import com.meritamerica.capstoneproject.repository.UserRepository;
import com.meritamerica.capstoneproject.service.AccountHolderService;

import javassist.NotFoundException;

@RestController
public class AccountHolderController {

	@Autowired
	AccountHolderService accountHolderService;
	
	@Autowired
	PersonalCheckingAccountRepository personalCheckingAccountRepo;

	

	public AccountHolderController(PersonalCheckingAccountRepository personalCheckingAccountRepo, AccountHolderRepository accountHolderRepo, UserRepository userRepo) {

		this.personalCheckingAccountRepo = personalCheckingAccountRepo;
		this.accountHolderService = new AccountHolderService(accountHolderRepo, personalCheckingAccountRepo, userRepo);
	}
	
	//AccountHolder
	//@PreAuthorize("hasAuthority('admin')")
	@PostMapping(value = "/AccountHolders")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addAccountHolder(@RequestBody @Valid AccountHolder accountHolder) {
	
		return accountHolderService.addAccountHolder(accountHolder); 
	}
	
	//@PreAuthorize("hasAuthority('admin')")
	@GetMapping(value = "/AccountHolders")
	@ResponseStatus(HttpStatus.OK)
	public List<AccountHolder> getAccountHolders() {
		
		return accountHolderService.getAccountHolders();
	}
	
	//@PreAuthorize("hasAuthority('admin')")
	@GetMapping(value = "/AccountHolders/{id}")
	@ResponseStatus(HttpStatus.OK)
	public AccountHolder getAccountById(@PathVariable long id) {

		
		return accountHolderService.getAccountById(id);
	}
	
	//PersonalCheckingAccount
	@PostMapping(value = "/AccountHolders/{id}/PersonalCheckingAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public PersonalCheckingAccount addPersonalCheckingAccount(@PathVariable(name = "id") long id, @RequestBody @Valid PersonalCheckingAccount peronsalCheckingAccount) {
		
		
		AccountHolder account = accountHolderService.getAccountById(id);
		
		peronsalCheckingAccount.setAccountHolder(account);

		account.addPersonalCheckingAccount(peronsalCheckingAccount);
		
		accountHolderService.addAccountHolder(account);
		peronsalCheckingAccount = accountHolderService.addPersonalCheckingAccount(peronsalCheckingAccount);
		
		return peronsalCheckingAccount;
		
	}
	
	@GetMapping(value = "/AccountHolders/{id}/PersonalCheckingAccount")
	@ResponseStatus(HttpStatus.OK)
	public List<PersonalCheckingAccount> getPersonalCheckingAccounts(@PathVariable(name = "id") long id) throws Exception, NotFoundException {
		
		AccountHolder account = accountHolderService.getAccountById(id);
		
		return account.getPersonalCheckingAccounts();
	}
	
}
