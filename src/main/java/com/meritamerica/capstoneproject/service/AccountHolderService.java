package com.meritamerica.capstoneproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.capstoneproject.models.AccountHolder;
import com.meritamerica.capstoneproject.models.BankAccount;
import com.meritamerica.capstoneproject.models.CDAccount;
import com.meritamerica.capstoneproject.models.DBACheckingAccount;
import com.meritamerica.capstoneproject.models.PersonalCheckingAccount;
import com.meritamerica.capstoneproject.models.RegularIRAAccount;
import com.meritamerica.capstoneproject.models.RolloverIRAAccount;
import com.meritamerica.capstoneproject.models.RothIRAAccount;
import com.meritamerica.capstoneproject.models.SavingsAccount;
import com.meritamerica.capstoneproject.repository.AccountHolderContactDetailsRepository;
import com.meritamerica.capstoneproject.repository.AccountHolderRepository;
import com.meritamerica.capstoneproject.repository.BankAccountRepository;
import com.meritamerica.capstoneproject.repository.CDAccountRepository;
import com.meritamerica.capstoneproject.repository.DBACheckingAccountRepository;
import com.meritamerica.capstoneproject.repository.PersonalCheckingAccountRepository;
import com.meritamerica.capstoneproject.repository.RegularIRAAccountRepository;
import com.meritamerica.capstoneproject.repository.RolloverIRAAccountRepository;
import com.meritamerica.capstoneproject.repository.RothIRAAccountRepository;
import com.meritamerica.capstoneproject.repository.SavingsAccountRepository;
import com.meritamerica.capstoneproject.repository.UserRepository;

@Service
public class AccountHolderService {

	@Autowired
	AccountHolderRepository accountHolderRepo;

	@Autowired
	PersonalCheckingAccountRepository personalCheckingAccountRepo;

	@Autowired
	SavingsAccountRepository savingsAccountRepo;

	@Autowired
	CDAccountRepository cdAccountRepo;
	
	@Autowired
	DBACheckingAccountRepository dbaCheckingAccountRepo;
	
	@Autowired
	RegularIRAAccountRepository regularIRAAccountRepo;
	
	@Autowired
	RolloverIRAAccountRepository rolloverIRAAccountRepo;
	
	@Autowired
	RothIRAAccountRepository rothIRAAccountRepo;

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

	public PersonalCheckingAccount addPersonalCheckingAccount(long id,
			PersonalCheckingAccount personalCheckingAccount) {

		AccountHolder account = getAccountById(id);

		account.addPersonalCheckingAccount(personalCheckingAccount);
		personalCheckingAccount.setAccountHolder(account);

		return personalCheckingAccountRepo.save(personalCheckingAccount);
	}

	public List<PersonalCheckingAccount> getPersonalCheckingAccounts(long id) {

		return getAccountById(id).getPersonalCheckingAccounts();

	}
	
	public PersonalCheckingAccount deletePersonalCheckingAccount(long id,
			PersonalCheckingAccount personalCheckingAccount) {

		//AccountHolder account = getAccountById(id);

		//account.setPersonalCheckingAccounts(null);
		//personalCheckingAccount.setAccountHolder(account);
		personalCheckingAccountRepo.deleteAll();
		return personalCheckingAccountRepo.save(personalCheckingAccount);
	}

	public SavingsAccount addSavingsAccount(long id, SavingsAccount savingsAccount) {

		AccountHolder account = getAccountById(id);

		account.addSavingsAccount(savingsAccount);
		savingsAccount.setAccountHolder(account);

		return savingsAccountRepo.save(savingsAccount);
	}

	public List<SavingsAccount> getSavingsAccounts(long id) {

		return getAccountById(id).getSavingsAccounts();

	}

	public CDAccount addcdAccount(long id, CDAccount cdAccount) {

		AccountHolder account = getAccountById(id);

		account.addCDAccount(cdAccount);
		cdAccount.setAccountHolder(account);

		return cdAccountRepo.save(cdAccount);
	}

	public List<CDAccount> getcdAccounts(long id) {

		return getAccountById(id).getCdAccounts();

	}
	
	public DBACheckingAccount addDBACheckingAccount(long id, DBACheckingAccount dbaCheckingAccount) {

		AccountHolder account = getAccountById(id);

		account.addDBACheckingAccount(dbaCheckingAccount);
		dbaCheckingAccount.setAccountHolder(account);

		return dbaCheckingAccountRepo.save(dbaCheckingAccount);
	}

	public List<DBACheckingAccount> getDBACheckingAccounts(long id) {

		return getAccountById(id).getDbaCheckingAccounts();

	}
	

	public RegularIRAAccount addRegularIRAAccount(long id, RegularIRAAccount regularIRAAccount) {

		AccountHolder account = getAccountById(id);

		account.addRegularIRAAccount(regularIRAAccount);
		regularIRAAccount.setAccountHolder(account);

		return regularIRAAccountRepo.save(regularIRAAccount);
	}

	public List<RegularIRAAccount> getRegularIRAAccounts(long id) {

		return getAccountById(id).getRegularIRAAccounts();

	}
	
	public RothIRAAccount addRothIRAAccount(long id, RothIRAAccount rothIRAAccount) {

		AccountHolder account = getAccountById(id);

		account.addRothIRAAccount(rothIRAAccount);
		rothIRAAccount.setAccountHolder(account);

		return rothIRAAccountRepo.save(rothIRAAccount);
	}

	public List<RothIRAAccount> getRothIRAAccounts(long id) {

		return getAccountById(id).getRothIRAAccounts();

	}
	
	public RolloverIRAAccount addRolloverIRAAccount(long id, RolloverIRAAccount rolloverIRAAccount) {

		AccountHolder account = getAccountById(id);

		account.addRolloverIRAAccount(rolloverIRAAccount);
		rolloverIRAAccount.setAccountHolder(account);

		return rolloverIRAAccountRepo.save(rolloverIRAAccount);
	}

	public List<RolloverIRAAccount> getRolloverIRAAccounts(long id) {

		return getAccountById(id).getRolloverIRAAccounts();

	}
	
}
