package com.meritamerica.capstoneproject.controllers;

import java.util.List;

import javax.validation.Valid;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.meritamerica.capstoneproject.exceptions.ExceedsAccountLimitException;
import com.meritamerica.capstoneproject.models.AccountHolder;
import com.meritamerica.capstoneproject.models.DBACheckingAccount;
import com.meritamerica.capstoneproject.models.PersonalCheckingAccount;
import com.meritamerica.capstoneproject.models.RegularIRAAccount;
import com.meritamerica.capstoneproject.models.RothIRAAccount;
import com.meritamerica.capstoneproject.models.SavingsAccount;
import com.meritamerica.capstoneproject.repository.AccountHolderRepository;
import com.meritamerica.capstoneproject.repository.BankAccountRepository;
import com.meritamerica.capstoneproject.repository.PersonalCheckingAccountRepository;
import com.meritamerica.capstoneproject.repository.SavingsAccountRepository;
import com.meritamerica.capstoneproject.repository.UserRepository;
import com.meritamerica.capstoneproject.service.AccountHolderService;

import javassist.NotFoundException;

@RestController
public class AccountHolderController {

	@Autowired
	AccountHolderService accountHolderService;	

	public AccountHolderController(AccountHolderRepository accountHolderRepo,
			PersonalCheckingAccountRepository personalCheckingAccountRepo,  UserRepository userRepo) {

		this.accountHolderService = new AccountHolderService(accountHolderRepo, personalCheckingAccountRepo, userRepo);
	}
	
	//AccountHolder
	//@PreAuthorize("hasAuthority('admin')")
	@PostMapping(value = "/AccountHolders")
	@ResponseStatus(HttpStatus.CREATED)
	public AccountHolder addAccountHolder(@RequestBody @Valid AccountHolder accountHolder) {
	
		//SavingsAccount savingsAccount = accountHolder.addSavingsAccount(new @Valid SavingsAccount(0));
		//accountHolderService.addBankAccount(savingsAccount);
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
	public PersonalCheckingAccount addPersonalCheckingAccount(@PathVariable(name = "id") long id, @RequestBody @Valid PersonalCheckingAccount peronsalCheckingAccount) throws ExceedsAccountLimitException {
		
		
		AccountHolder account = accountHolderService.getAccountById(id);
		/*
		peronsalCheckingAccount.setAccountHolder(account);

		account.addPersonalCheckingAccount(peronsalCheckingAccount);
		
		accountHolderService.addAccountHolder(account);
		
		
		if (account.getPersonalCheckingAccounts() != null) {
			throw new ExceedsAccountLimitException();
		}
		*/
		peronsalCheckingAccount = accountHolderService.addPersonalCheckingAccount(id, peronsalCheckingAccount);
		
		
		return peronsalCheckingAccount;
		
	}
	
	@GetMapping(value = "/AccountHolders/{id}/PersonalCheckingAccount")
	@ResponseStatus(HttpStatus.OK)
	public List<PersonalCheckingAccount> getPersonalCheckingAccounts(@PathVariable(name = "id") long id) throws Exception, NotFoundException {
		
		return accountHolderService.getPersonalCheckingAccounts(id);
		
	}
	
	//SavingsAccount
	@PostMapping(value = "/AccountHolders/{id}/SavingsAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public SavingsAccount addSavingsAccount(@PathVariable(name = "id") long id, @RequestBody @Valid SavingsAccount savingsAccount) {
		
		savingsAccount = accountHolderService.addSavingsAccount(id, savingsAccount);
		
		return savingsAccount;
		
	}
	
	@GetMapping(value = "/AccountHolders/{id}/SavingsAccount")
	@ResponseStatus(HttpStatus.OK)
	public List<SavingsAccount> getSavingsAccounts(@PathVariable(name = "id") long id) throws Exception, NotFoundException {
		
		return accountHolderService.getSavingsAccounts(id);
	}
	
	//DBACheckingAccount
	@PostMapping(value = "/AccountHolders/{id}/DBACheckingAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public DBACheckingAccount addDBACheckingAccount(@PathVariable(name = "id") long id, @RequestBody @Valid DBACheckingAccount dbaCheckingAccount) {
		
		dbaCheckingAccount = accountHolderService.addDBACheckingAccount(id, dbaCheckingAccount);
		
		return dbaCheckingAccount;
		
	}
	
	@GetMapping(value = "/AccountHolders/{id}/DBACheckingAccount")
	@ResponseStatus(HttpStatus.OK)
	public List<DBACheckingAccount> getDBACheckingAccounts(@PathVariable(name = "id") long id) throws Exception, NotFoundException {
		
		return accountHolderService.getDBACheckingAccounts(id);
	}
	
	//RegularIRAAccount
	@PostMapping(value = "/AccountHolders/{id}/RegularIRAAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public RegularIRAAccount addRegularIRAAccount(@PathVariable(name = "id") long id, @RequestBody @Valid RegularIRAAccount regularIRAAccount) {
		
		regularIRAAccount = accountHolderService.addRegularIRAAccount(id, regularIRAAccount);
		
		return regularIRAAccount;
		
	}
	
	@GetMapping(value = "/AccountHolders/{id}/RegularIRAAccount")
	@ResponseStatus(HttpStatus.OK)
	public List<RegularIRAAccount> getRegularIRAAccounts(@PathVariable(name = "id") long id) throws Exception, NotFoundException {
		
		return accountHolderService.getRegularIRAAccounts(id);
	}
	
	//RothIRAAccount
	@PostMapping(value = "/AccountHolders/{id}/RothIRAAccount")
	@ResponseStatus(HttpStatus.CREATED)
	public RothIRAAccount addRothIRAAccount(@PathVariable(name = "id") long id, @RequestBody @Valid RothIRAAccount rothIRAAccount) {
		
		rothIRAAccount = accountHolderService.addRothIRAAccount(id, rothIRAAccount);
		
		return rothIRAAccount;
		
	}
	
	@GetMapping(value = "/AccountHolders/{id}/RothIRAAccount")
	@ResponseStatus(HttpStatus.OK)
	public List<RothIRAAccount> getRothIRAAccounts(@PathVariable(name = "id") long id) throws Exception, NotFoundException {
		
		return accountHolderService.getRothIRAAccounts(id);
	}
	
}
