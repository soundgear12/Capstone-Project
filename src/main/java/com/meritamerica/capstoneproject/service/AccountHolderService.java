package com.meritamerica.capstoneproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.capstoneproject.models.AccountHolder;
import com.meritamerica.capstoneproject.models.PersonalCheckingAccount;
import com.meritamerica.capstoneproject.repository.AccountHolderRepository;
import com.meritamerica.capstoneproject.repository.PersonalCheckingAccountRepository;
import com.meritamerica.capstoneproject.repository.UserRepository;

@Service
public class AccountHolderService {

	@Autowired
	AccountHolderRepository accountHolderRepo;
	
	@Autowired
	PersonalCheckingAccountRepository personalCheckingAccountRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public AccountHolderService(AccountHolderRepository accountHolderRepo,
			PersonalCheckingAccountRepository personalCheckingAccountRepo, UserRepository userRepo) {
		this.accountHolderRepo = accountHolderRepo;
		this.personalCheckingAccountRepo = personalCheckingAccountRepo;
		this.userRepo = userRepo;
	}

	public AccountHolder addAccountHolder(AccountHolder accountHolder) {
		return accountHolderRepo.save(accountHolder);
	}
	
	public List<AccountHolder> getAccountHolders() {
		return accountHolderRepo.findAll();
	}
	
	public AccountHolder getAccountById(long id) {
		return accountHolderRepo.getById(id);
	}
	
	public PersonalCheckingAccount addPersonalCheckingAccount(PersonalCheckingAccount personalCheckingAccount) {
		return personalCheckingAccountRepo.save(personalCheckingAccount);
	}
	
	public List<PersonalCheckingAccount> getPersonalCheckingAccounts() {
		return personalCheckingAccountRepo.findAll();
	}


	
}
